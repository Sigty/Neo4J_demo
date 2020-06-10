package com.dulik.nosql.Neo4J.service;

import com.dulik.nosql.Neo4J.entity.Project;
import com.dulik.nosql.Neo4J.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserService userService;

    public boolean saveProject(Project newProject) {
        if (newProject != null) {
            projectRepository.save(newProject);
            return true;
        }
        return false;
    }

    public List<Project> getAllProjects() {
        return StreamSupport
                .stream(projectRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Project> getProjectById(Long idProject) {
        return projectRepository.findById(idProject);
    }

    public void deleteProject(Long idProject) {
        getProjectById(idProject).ifPresent(projectRepository::delete);
    }
}
