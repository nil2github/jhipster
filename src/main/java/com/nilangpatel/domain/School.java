package com.nilangpatel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.nilangpatel.domain.enumeration.EducationType;

/**
 * A School.
 */
@Entity
@Table(name = "school")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "edu_type", nullable = false)
    private EducationType eduType;

    @NotNull
    @Min(value = 5)
    @Max(value = 99)
    @Column(name = "no_of_rooms", nullable = false)
    private Integer noOfRooms;

    @OneToMany(mappedBy = "school")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Teacher> teachers = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public School name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EducationType getEduType() {
        return eduType;
    }

    public School eduType(EducationType eduType) {
        this.eduType = eduType;
        return this;
    }

    public void setEduType(EducationType eduType) {
        this.eduType = eduType;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public School noOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
        return this;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public School teachers(Set<Teacher> teachers) {
        this.teachers = teachers;
        return this;
    }

    public School addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.setSchool(this);
        return this;
    }

    public School removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
        teacher.setSchool(null);
        return this;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        School school = (School) o;
        if (school.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), school.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "School{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", eduType='" + getEduType() + "'" +
            ", noOfRooms=" + getNoOfRooms() +
            "}";
    }
}
