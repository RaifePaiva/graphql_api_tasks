package br.com.puc.apigraphql.model;

public enum TaskStatus {

    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");

    private String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
