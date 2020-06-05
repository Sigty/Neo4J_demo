package com.dulik.nosql.Neo4J.repository;

import com.dulik.nosql.Neo4J.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
}
