package com.github.elijasp.workouttracker.exceptions;

public class EntityIdNotFoundResponse {
    // == fields ==
    private String id;

    // == constructor ==
    public EntityIdNotFoundResponse(String id) {
        this.id = id;
    }

    // == getters and setters ==
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
