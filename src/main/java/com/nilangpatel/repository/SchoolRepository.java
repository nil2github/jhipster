package com.nilangpatel.repository;

import com.nilangpatel.domain.School;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the School entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
