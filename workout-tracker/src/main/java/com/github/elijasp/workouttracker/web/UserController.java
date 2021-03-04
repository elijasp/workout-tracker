package com.github.elijasp.workouttracker.web;

import com.github.elijasp.workouttracker.domain.User;
import com.github.elijasp.workouttracker.services.ErrorValidationService;
import com.github.elijasp.workouttracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    // == fields ==
    private final UserService userService;
    private final ErrorValidationService errorValidationService;
    // == DI constructor ==
    @Autowired
    public UserController(UserService userService,
                          ErrorValidationService errorValidationService){
        this.userService = userService;
        this.errorValidationService = errorValidationService;
    }

    @PostMapping("")
    public ResponseEntity<?> saveUser(@RequestBody @Valid User user, BindingResult result){
        // validate user
        ResponseEntity<?> validationErrors = errorValidationService.errorValidation(result);
        if(validationErrors == null) return validationErrors;
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }


}
