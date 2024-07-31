package com.example.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travelapp.model.Travel;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {
    List<Travel> findByUserId(Long userId);
}