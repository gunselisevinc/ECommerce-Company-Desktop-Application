package com.team14.WebService.repository;

import com.team14.WebService.entity.Computer;
import com.team14.WebService.entity.computerComments;
import com.team14.WebService.entity.computerFeatures;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Encapsulate the logic required to access Computer Comment data sources
 */
public interface ComputerCommentRepository extends JpaRepository<computerComments, Integer> {
}
