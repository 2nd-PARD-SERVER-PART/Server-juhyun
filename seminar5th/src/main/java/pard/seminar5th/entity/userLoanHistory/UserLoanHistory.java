package pard.seminar5th.entity.userLoanHistory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long userId;
    private String bookName;
    private boolean isReturn;

    public UserLoanHistory(Long userId,String bookName){
        this.userId = userId;
        this.bookName = bookName;
    }

}
