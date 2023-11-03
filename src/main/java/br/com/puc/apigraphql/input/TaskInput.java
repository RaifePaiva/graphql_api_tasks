package br.com.puc.apigraphql.input;

import lombok.Data;

@Data
public class TaskInput {

    private String title;
    private String description;
    private Long userId;

}
