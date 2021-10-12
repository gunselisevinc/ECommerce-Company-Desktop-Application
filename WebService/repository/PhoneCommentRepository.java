package com.team14.WebService.repository;

import com.team14.WebService.entity.computerComments;
import com.team14.WebService.entity.phoneComments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Encapsulate the logic required to access Phone Comment data sources
 */
public interface PhoneCommentRepository extends JpaRepository<phoneComments, Integer>{

}
