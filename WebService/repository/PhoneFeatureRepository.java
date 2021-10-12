package com.team14.WebService.repository;

import com.team14.WebService.entity.computerComments;
import com.team14.WebService.entity.phoneFeatures;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Encapsulate the logic required to access Phone Feature data sources
 */
public interface PhoneFeatureRepository  extends JpaRepository<phoneFeatures, Integer> {
}
