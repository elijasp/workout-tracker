package com.github.elijasp.workouttracker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "workout")
public class Workout {
    // == fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Muscles worked is required")
    @Column(name = "muscles")
    private String muscles;
    @NotBlank(message = "Description of workout is required")
    @Column(name = "description")
    private String description;
    @NotNull(message = "DateTime of workout is required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column( name = "workout_datetime")
    private LocalDateTime workoutDateTime;

    // == constructors ==
    public Workout(){}

    // == getters and setters ==
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMuscles() {
        return muscles;
    }

    public void setMuscles(String muscles) {
        this.muscles = muscles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getWorkoutDateTime() {
        return workoutDateTime;
    }

    public void setWorkoutDateTime(LocalDateTime workoutDateTime) {
        this.workoutDateTime = workoutDateTime;
    }
}
