package com.github.elijasp.workouttracker.repositories;

import com.github.elijasp.workouttracker.domain.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {
}
