package com.HMRS.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "classes")
public class Training implements Serializable {

    @Id
    private long id;

    @Column(name = "name")
    private String className;
    @Column(name="linkToTraining")
    private String linkToTraining;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String courseName) {
        this.className = courseName;
    }

    public String getLinkToTraining() {
        return linkToTraining;
    }

    public void setLinkToTraining(String linkToTraining) {
        this.linkToTraining = linkToTraining;
    }


    /*@ManyToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Employee> employees = new HashSet<>();*/



}
