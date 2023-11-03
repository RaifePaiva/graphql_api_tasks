package br.com.puc.apigraphql.repository;

import br.com.puc.apigraphql.model.TaskModel;
import br.com.puc.apigraphql.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    List<TaskModel> findAllByStatus(TaskStatus taskStatus);
}
