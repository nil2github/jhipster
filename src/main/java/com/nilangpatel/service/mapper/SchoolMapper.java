package com.nilangpatel.service.mapper;

import com.nilangpatel.domain.*;
import com.nilangpatel.service.dto.SchoolDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity School and its DTO SchoolDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SchoolMapper extends EntityMapper<SchoolDTO, School> {


    @Mapping(target = "teachers", ignore = true)
    School toEntity(SchoolDTO schoolDTO);

    default School fromId(Long id) {
        if (id == null) {
            return null;
        }
        School school = new School();
        school.setId(id);
        return school;
    }
}
