package com.dulik.nosql.Neo4J.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(of = {"id", "roles", "user", "project"})
@AllArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type = "ROLE")
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private List<String> roles = new ArrayList<>();

    @JsonIgnoreProperties("participate")
    @StartNode
    private User user;

    @JsonIgnoreProperties("members")
    @EndNode
    private Project project;
}
