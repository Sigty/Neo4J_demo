package com.dulik.nosql.Neo4J.service;

import com.dulik.nosql.Neo4J.entity.User;
import com.dulik.nosql.Neo4J.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public boolean saveUser(User newUser) {
        if (newUser != null) {
            userRepository.save(newUser);
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<User> getUserById(Long idUser) {
        return userRepository.findById(idUser);
    }

    public void deleteGuitar(Long idGuitar) {
        getUserById(idGuitar).ifPresent(userRepository::delete);
    }
}
