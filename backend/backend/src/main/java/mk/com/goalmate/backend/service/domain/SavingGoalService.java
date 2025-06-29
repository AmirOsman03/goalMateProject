package mk.com.goalmate.backend.service.domain;

import mk.com.goalmate.backend.model.SavingGoal;

import java.util.List;
import java.util.Optional;

public interface SavingGoalService {

    List<SavingGoal> findAll();

    Optional<SavingGoal> findById(Long id);

    SavingGoal save(SavingGoal goal);

    Optional<SavingGoal> update(Long id, SavingGoal goal);

    void deleteById(Long id);

}
