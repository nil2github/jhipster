package com.nilangpatel.service.impl;

import com.nilangpatel.service.SchoolService;
import com.nilangpatel.domain.School;
import com.nilangpatel.repository.SchoolRepository;
import com.nilangpatel.service.dto.SchoolDTO;
import com.nilangpatel.service.mapper.SchoolMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing School.
 */
@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {

    private final Logger log = LoggerFactory.getLogger(SchoolServiceImpl.class);

    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolServiceImpl(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    /**
     * Save a school.
     *
     * @param schoolDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SchoolDTO save(SchoolDTO schoolDTO) {
        log.debug("Request to save School : {}", schoolDTO);

        School school = schoolMapper.toEntity(schoolDTO);
        school = schoolRepository.save(school);
        return schoolMapper.toDto(school);
    }

    /**
     * Get all the schools.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SchoolDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Schools");
        return schoolRepository.findAll(pageable)
            .map(schoolMapper::toDto);
    }


    /**
     * Get one school by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SchoolDTO> findOne(Long id) {
        log.debug("Request to get School : {}", id);
        return schoolRepository.findById(id)
            .map(schoolMapper::toDto);
    }

    /**
     * Delete the school by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete School : {}", id);
        schoolRepository.deleteById(id);
    }
}
