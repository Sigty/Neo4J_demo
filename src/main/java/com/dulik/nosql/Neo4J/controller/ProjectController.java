package com.dulik.nosql.Neo4J.controller;

import com.dulik.nosql.Neo4J.entity.Project;
import com.dulik.nosql.Neo4J.service.ProjectService;
import com.dulik.nosql.Neo4J.service.RoleService;
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

@RequestMapping("v1/project")
@RequiredArgsConstructor
@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final RoleService roleService;

    @GetMapping(value = "/echo")
    public ResponseEntity<Map<String, Object>> echo() {
        return ResponseEntity.ok(Collections.singletonMap("ok", true));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> saveUser(@RequestBody Project newProject) {
        boolean result = projectService.saveProject(newProject);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<Project> getUser(@RequestParam(value = "id") Long idProject) {
        return ResponseEntity.ok().body(projectService.getProjectById(idProject).orElse(null));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Project>> getUsers() {
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateUser(@RequestBody Project editProject) {
        projectService.saveProject(editProject);
        return ResponseEntity.ok().body(true);
    }

    @GetMapping("/addUser")
    public ResponseEntity<Boolean> updateUser(@RequestParam(value = "idProject") Long idProject,
                                              @RequestParam(value = "idUser") Long idUser,
                                              @RequestParam(value = "role", required = false) List<String> roles) {
        roleService.addUserToProject(idProject, idUser, roles != null && !roles.isEmpty() ? roles : List.of());
        return ResponseEntity.ok().body(true);
    }

}
