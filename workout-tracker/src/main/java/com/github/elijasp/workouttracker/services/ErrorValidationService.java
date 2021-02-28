package com.github.elijasp.workouttracker.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErrorValidationService {
        public ResponseEntity<?> errorValidation(BindingResult result){
            if(result.hasErrors()){
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(err -> {
                    errors.put(err.getField(), err.getDefaultMessage());
                });
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            return null;
    }
}
