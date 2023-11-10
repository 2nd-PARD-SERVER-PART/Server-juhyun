package pard.seminar5th.dto.bookLoanRequest;

import lombok.Data;

@Data
public class BookLoanRequest {
    private Long userId;
    private String bookName;
}
