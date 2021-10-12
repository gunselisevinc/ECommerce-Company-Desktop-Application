package com.team14.WebService.repository;

import com.team14.WebService.entity.computerComments;
import com.team14.WebService.entity.computerFeatures;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Encapsulate the logic required to access Computer Feature data sources
 */
public interface ComputerFeatureRepository  extends JpaRepository<computerFeatures, Integer> {
}
