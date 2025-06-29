package mk.com.goalmate.backend.service.domain.impl;

import mk.com.goalmate.backend.model.SavingGoal;
import mk.com.goalmate.backend.repository.SavingGoalRepository;
import mk.com.goalmate.backend.service.domain.SavingGoalService;
import org.springframework.stereotype.Service;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
public class SavingGoalServiceImpl implements SavingGoalService {

    private final SavingGoalRepository savingGoalRepository;

    public SavingGoalServiceImpl(SavingGoalRepository savingGoalRepository) {
        this.savingGoalRepository = savingGoalRepository;
    }

    @Override
    public List<SavingGoal> findAll() {
        return savingGoalRepository.findAll();
    }

    @Override
    public Optional<SavingGoal> findById(Long id) {
        return savingGoalRepository.findById(id);
    }

    @Override
    public SavingGoal save(SavingGoal goal) {
        return savingGoalRepository.save(goal);
    }

    @Override
    public Optional<SavingGoal> update(Long id, SavingGoal goal) {
        return savingGoalRepository.findById(id)
                .map((existingGoal) -> {
                    existingGoal.setName(goal.getName());
                    existingGoal.setDateCreated(YearMonth.now());
                    existingGoal.setTargetDate(goal.getTargetDate());
                    existingGoal.setUser(goal.getUser());

                    return savingGoalRepository.save(existingGoal);
                });
    }

    @Override
    public void deleteById(Long id) {
        savingGoalRepository.deleteById(id);
    }

}
