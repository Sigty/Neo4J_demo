package com.dulik.nosql.Neo4J.service;

import com.dulik.nosql.Neo4J.entity.Project;
import com.dulik.nosql.Neo4J.entity.Role;
import com.dulik.nosql.Neo4J.entity.RoleEnum;
import com.dulik.nosql.Neo4J.entity.User;
import com.dulik.nosql.Neo4J.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final UserService userService;
    private final ProjectService projectService;
    private final RoleRepository roleRepository;

    public void addUserToProject(Long idProject, Long idUser, List<String> roles) {
        Optional<User> user = userService.getUserById(idUser);
        Optional<Project> project = projectService.getProjectById(idProject);
        if (user.isPresent() && project.isPresent()) {
            Role role = new Role();
            user.ifPresent(role::setUser);
            project.ifPresent(role::setProject);
//            TODO Check roles
            Optional<Role> byId = roleRepository.findById(4L);
            System.out.println(byId);
            project.ifPresent(p -> role.setRoles(checkRoles(roles)));
            project.ifPresent(p -> p.setMembers(List.of(role)));
            project.ifPresent(projectService::saveProject);
        }
    }

    private List<String> checkRoles(List<String> roles) {
        List<String> stringList = roles
                .stream()
                .filter(r -> r.equalsIgnoreCase(RoleEnum.ADMIN.name())
                        || r.equalsIgnoreCase(RoleEnum.USER.name())
                        || r.equalsIgnoreCase(RoleEnum.MANAGER.name())).collect(Collectors.toList());
        return stringList.isEmpty() ? List.of(RoleEnum.USER.name()) : stringList;
    }
}
