package com.ssafyss.board_practice.todo.application;

public class UpdateTodoDto {
    private int id;
    private  boolean completed;

    public UpdateTodoDto(int id, boolean completed) {
        this.id = id;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
