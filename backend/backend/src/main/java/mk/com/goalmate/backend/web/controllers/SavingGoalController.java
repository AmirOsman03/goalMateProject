package mk.com.goalmate.backend.web.controllers;


import jakarta.annotation.PostConstruct;
import mk.com.goalmate.backend.model.SavingGoal;
import mk.com.goalmate.backend.service.domain.SavingGoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saving-goal")
public class SavingGoalController {

    private final SavingGoalService savingGoalService;

    public SavingGoalController(SavingGoalService savingGoalService) {
        this.savingGoalService = savingGoalService;
    }

    @GetMapping
    public List<SavingGoal> findAll() {
        return this.savingGoalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingGoal> findById(@PathVariable Long id) {
        return this.savingGoalService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<SavingGoal> save(@RequestBody SavingGoal savingGoal) {
        return ResponseEntity.ok(savingGoalService.save(savingGoal));
    }
}
