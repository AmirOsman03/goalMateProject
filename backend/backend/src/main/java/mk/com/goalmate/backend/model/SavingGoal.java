package mk.com.goalmate.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.YearMonth;

@Data
@Entity
@NoArgsConstructor
public class SavingGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int targetPrice;
    private YearMonth dateCreated;
    private YearMonth targetDate;

    @ManyToOne
    private User user;

    public SavingGoal(String name, int targetPrice, YearMonth targetDate, User user) {
        this.name = name;
        this.targetPrice = targetPrice;
        this.targetDate = targetDate;
        this.user = user;
        this.dateCreated = YearMonth.now();
    }

}
