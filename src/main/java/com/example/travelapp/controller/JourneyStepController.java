package com.example.travelapp.controller;

import com.example.travelapp.model.JourneyStep;
import com.example.travelapp.repository.JourneyStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journey-steps")
public class JourneyStepController {

    @Autowired
    private JourneyStepRepository journeyStepRepository;

    @GetMapping("/travel/{travelId}")
    public List<JourneyStep> getJourneyStepsByTravelId(@PathVariable Long travelId) {
        return journeyStepRepository.findByTravelId(travelId);
    }

    @PostMapping("/")
    public JourneyStep createJourneyStep(@RequestBody JourneyStep journeyStep) {
        return journeyStepRepository.save(journeyStep);
    }

    @GetMapping("/{id}")
    public Optional<JourneyStep> getJourneyStep(@PathVariable Long id) {
        return journeyStepRepository.findById(id);
    }

    @PutMapping("/{id}")
    public JourneyStep updateJourneyStep(@PathVariable Long id, @RequestBody JourneyStep journeyStepDetails) {
        JourneyStep journeyStep = journeyStepRepository.findById(id).orElseThrow();
        journeyStep.setTitle(journeyStepDetails.getTitle());
        journeyStep.setDescription(journeyStepDetails.getDescription());
        journeyStep.setDate(journeyStepDetails.getDate());
        journeyStep.setImage(journeyStepDetails.getImage());
        journeyStep.setFood(journeyStepDetails.getFood());
        journeyStep.setCuriosities(journeyStepDetails.getCuriosities());
        return journeyStepRepository.save(journeyStep);
    }

    @DeleteMapping("/{id}")
    public void deleteJourneyStep(@PathVariable Long id) {
        journeyStepRepository.deleteById(id);
    }
}