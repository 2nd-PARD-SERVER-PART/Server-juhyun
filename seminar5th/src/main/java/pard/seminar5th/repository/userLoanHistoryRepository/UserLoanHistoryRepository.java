package pard.seminar5th.repository.userLoanHistoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.seminar5th.entity.userLoanHistory.UserLoanHistory;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory,Long> {
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);
}
