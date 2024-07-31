package com.example.travelapp.controller;

import com.example.travelapp.model.Travel;
import com.example.travelapp.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/travels")
public class TravelController {

    @Autowired
    private TravelRepository travelRepository;

    @GetMapping("/user/{userId}")
    public List<Travel> getTravelsByUserId(@PathVariable Long userId) {
        return travelRepository.findByUserId(userId);
    }

    @PostMapping("/")
    public Travel createTravel(@RequestBody Travel travel) {
        return travelRepository.save(travel);
    }

    @GetMapping("/{id}")
    public Optional<Travel> getTravel(@PathVariable Long id) {
        return travelRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Travel updateTravel(@PathVariable Long id, @RequestBody Travel travelDetails) {
        Travel travel = travelRepository.findById(id).orElseThrow();
        travel.setTitle(travelDetails.getTitle());
        travel.setDescription(travelDetails.getDescription());
        travel.setStartDate(travelDetails.getStartDate());
        travel.setEndDate(travelDetails.getEndDate());
        return travelRepository.save(travel);
    }

    @DeleteMapping("/{id}")
    public void deleteTravel(@PathVariable Long id) {
        travelRepository.deleteById(id);
    }
}