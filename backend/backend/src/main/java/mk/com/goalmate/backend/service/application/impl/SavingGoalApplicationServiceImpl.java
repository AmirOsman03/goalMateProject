package mk.com.goalmate.backend.service.application.impl;

import mk.com.goalmate.backend.model.SavingGoal;
import mk.com.goalmate.backend.repository.SavingGoalRepository;
import mk.com.goalmate.backend.service.domain.SavingGoalService;
import mk.com.goalmate.backend.service.domain.impl.SavingGoalServiceImpl;

import java.util.List;
import java.util.Optional;

public class SavingGoalApplicationServiceImpl implements SavingGoalService {

    private final SavingGoalServiceImpl savingGoalRepository;

    public SavingGoalApplicationServiceImpl(SavingGoalServiceImpl savingGoalService) {
        this.savingGoalRepository = savingGoalService;
    }

    @Override
    public List<SavingGoal> findAll() {
        return savingGoalRepository.findAll();
    }

    @Override
    public Optional<SavingGoal> findById(Long id) {
        return this.savingGoalRepository.findById(id);
    }

    @Override
    public SavingGoal save(SavingGoal goal) {
        return this.savingGoalRepository.save(goal);
    }

    @Override
    public Optional<SavingGoal> update(Long id, SavingGoal goal) {
        return this.savingGoalRepository.update(id,goal);

    }

    @Override
    public void deleteById(Long id) {
        this.savingGoalRepository.deleteById(id);
    }
}
