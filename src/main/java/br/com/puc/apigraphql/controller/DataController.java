package br.com.puc.apigraphql.controller;

import br.com.puc.apigraphql.input.TaskInput;
import br.com.puc.apigraphql.model.ResponseModel;
import br.com.puc.apigraphql.model.TaskModel;
import br.com.puc.apigraphql.model.TaskStatus;
import br.com.puc.apigraphql.model.UserModel;
import br.com.puc.apigraphql.repository.TaskRepository;
import br.com.puc.apigraphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class DataController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @MutationMapping
    TaskModel createTask(@Argument TaskInput task) {
        var user = userRepository.findById(task.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        var loadTask = new TaskModel(task.getTitle(), task.getDescription(), user);
        return taskRepository.save(loadTask);
    }

    @MutationMapping
    TaskModel completeTask(@Argument Long id) {
        var task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        if(!Objects.equals(task.getStatus().getStatus(), TaskStatus.IN_PROGRESS.getStatus()))
            throw new RuntimeException("Task is not in progress");

        task.setStatus(TaskStatus.DONE);
        return taskRepository.save(task);
    }

    @MutationMapping
    TaskModel updateTask(@Argument Long id, @Argument TaskInput task) {
        var loadTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        var loadUser = userRepository.findById(task.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        loadTask.setTitle(task.getTitle());
        loadTask.setDescription(task.getDescription());
        loadTask.setUser(loadUser);
        return taskRepository.save(loadTask);
    }

    @MutationMapping
    ResponseModel deleteTask(@Argument Long id) {
        try {
            var loadTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
            taskRepository.delete(loadTask);
            return new ResponseModel(true, "Task deleted successfully");
        }catch (Exception e) {
            return new ResponseModel(false, e.getMessage());
        }
    }

    @QueryMapping
    List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    @QueryMapping
    TaskModel getTask(@Argument Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @QueryMapping
    List<TaskModel> getAllTasksByStatus(@Argument TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @QueryMapping
    List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }


}
