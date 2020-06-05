package com.dulik.nosql.Neo4J.repository;

import com.dulik.nosql.Neo4J.entity.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends Neo4jRepository<Project, Long> {
}
