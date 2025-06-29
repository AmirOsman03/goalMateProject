package mk.com.goalmate.backend.service.application;

import mk.com.goalmate.backend.model.SavingGoal;

import java.util.List;
import java.util.Optional;

public interface SavingGoalAplicationService {

    List<SavingGoal> findAll();

    Optional<SavingGoal> findById(Long id);

    Optional<SavingGoal> save(SavingGoal savingGoal);

    Optional<SavingGoal> update(SavingGoal savingGoal);

    void deleteById(Long id);

}
