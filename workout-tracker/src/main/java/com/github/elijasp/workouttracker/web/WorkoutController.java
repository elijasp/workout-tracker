package com.github.elijasp.workouttracker.web;

import com.github.elijasp.workouttracker.domain.Workout;
import com.github.elijasp.workouttracker.services.ErrorValidationService;
import com.github.elijasp.workouttracker.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    // == fields ==
    private final WorkoutService workoutService;
    private final ErrorValidationService validationService;

    // == DI constructor ==
    @Autowired
    public WorkoutController(WorkoutService workoutService,
                             ErrorValidationService validationService){
        this.workoutService = workoutService;
        this.validationService = validationService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveWorkout(@RequestBody @Valid Workout workout, BindingResult result) {
        // validation check for errors
        ResponseEntity<?> validationErrors = validationService.errorValidation(result);
        if(validationErrors != null) return validationErrors;
        // if no validation errors save workout
        Workout savedWorkout = workoutService.saveWorkout(workout);
        return new ResponseEntity<>(savedWorkout, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> findWorkoutById(@PathVariable Long id){
        Workout foundWorkout = workoutService.findWorkoutById(id);
        return new ResponseEntity<>(foundWorkout, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Workout> findAllWorkouts(){
        return workoutService.findAll();
    }
}
