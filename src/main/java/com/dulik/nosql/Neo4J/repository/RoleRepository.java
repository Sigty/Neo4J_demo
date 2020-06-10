package com.dulik.nosql.Neo4J.repository;

import com.dulik.nosql.Neo4J.entity.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<Role, Long> {
}
