package com.dulik.nosql.Neo4J.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;

@AllArgsConstructor
@NoArgsConstructor
@Data
@NodeEntity
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnoreProperties({"user", "project"})
    @Relationship(type = "PARTICIPATE", direction = INCOMING)
    private List<Role> members = new ArrayList<>();
}
