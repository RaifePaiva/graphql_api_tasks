package br.com.puc.apigraphql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_tasks")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.IN_PROGRESS;
    private Instant createdAt = Instant.now();

    @ManyToOne
    private UserModel user;

    public TaskModel(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public TaskModel(String title, String description, UserModel user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
}
