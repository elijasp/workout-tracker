package com.github.elijasp.workouttracker.services;

import com.github.elijasp.workouttracker.domain.Workout;
import com.github.elijasp.workouttracker.exceptions.EntityIdNotFoundException;
import com.github.elijasp.workouttracker.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Workout findWorkoutById(Long id){
        Optional<Workout> workout = repository.findById(id);
        if(!workout.isPresent()){
           throw new EntityIdNotFoundException("Workout with id |" + id + "| does not exist.");
        }
        return workout.get();
    }
}
