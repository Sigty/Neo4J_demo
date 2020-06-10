package com.dulik.nosql.Neo4J.controller;

import com.dulik.nosql.Neo4J.entity.User;
import com.dulik.nosql.Neo4J.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequestMapping("v1/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/echo")
    public ResponseEntity<Map<String, Object>> echo() {
        return ResponseEntity.ok(Collections.singletonMap("ok", true));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> saveUser(@RequestBody User newUser) {
        boolean result = userService.saveUser(newUser);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUser(@RequestParam(value = "id") Long idUser) {
        return ResponseEntity.ok().body(userService.getUserById(idUser).orElse(null));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> updateUser(@RequestBody User editUser) {
        userService.saveUser(editUser);
        return ResponseEntity.ok().body(true);
    }
}
