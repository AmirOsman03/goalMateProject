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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public YearMonth getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(YearMonth dateCreated) {
        this.dateCreated = dateCreated;
    }

    public YearMonth getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(YearMonth targetDate) {
        this.targetDate = targetDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
