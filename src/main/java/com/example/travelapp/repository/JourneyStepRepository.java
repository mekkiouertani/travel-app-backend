package com.example.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelapp.model.JourneyStep;

import java.util.List;

public interface JourneyStepRepository extends JpaRepository<JourneyStep, Long> {
    List<JourneyStep> findByTravelId(Long travelId);
}
