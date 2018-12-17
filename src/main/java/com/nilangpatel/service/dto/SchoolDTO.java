package com.nilangpatel.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.nilangpatel.domain.enumeration.EducationType;

/**
 * A DTO for the School entity.
 */
public class SchoolDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private EducationType eduType;

    @NotNull
    @Min(value = 5)
    @Max(value = 99)
    private Integer noOfRooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EducationType getEduType() {
        return eduType;
    }

    public void setEduType(EducationType eduType) {
        this.eduType = eduType;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SchoolDTO schoolDTO = (SchoolDTO) o;
        if (schoolDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), schoolDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SchoolDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", eduType='" + getEduType() + "'" +
            ", noOfRooms=" + getNoOfRooms() +
            "}";
    }
}
