package com.github.elijasp.workouttracker.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "workout")
public class Workout {
    // == fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "muscles")
    private String muscles;
    @Column(name = "description")
    private String description;
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
