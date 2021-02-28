package com.github.elijasp.workouttracker.services;

import com.github.elijasp.workouttracker.domain.Workout;
import com.github.elijasp.workouttracker.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {
    // == fields ==
    private final WorkoutRepository repository;

    // == DI constructor ==
    @Autowired
    public WorkoutService(WorkoutRepository repository){
        this.repository = repository;
    }

    public Workout saveWorkout(Workout workout) {
        return repository.save(workout);
    }
}
