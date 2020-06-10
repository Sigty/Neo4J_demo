package com.dulik.nosql.Neo4J.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = {"participate"})
@ToString(of = {"id", "firstName", "lastName"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @JsonIgnoreProperties({"user", "project"})
    @Relationship(type = "ROLE")
    private List<Role> participate = new ArrayList<>();
}
