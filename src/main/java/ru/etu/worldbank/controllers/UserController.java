package ru.etu.worldbank.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.etu.worldbank.dto.UserDTO;
import ru.etu.worldbank.models.User;
import ru.etu.worldbank.service.UserService;

@RestController
public class UserController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UserController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(path = "/api/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAuthUser(@RequestBody UserDTO userDTO) {
        try {
            User user = convertToEntity(userDTO);
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity("You are successfully logged in!", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("Incorrect username or password!", HttpStatus.UNAUTHORIZED);
        }
    }

    private User convertToEntity(UserDTO userDTO)  {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    @PostMapping(path = "/api/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody UserDTO userDTO)  {
        User user = convertToEntity(userDTO);
        if (service.addUser(user) != null) {
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            return new ResponseEntity("You have successfully registered!", HttpStatus.OK);
        }
        else
            return new ResponseEntity("User with this login already exists!", HttpStatus.UNAUTHORIZED);
    }
}
