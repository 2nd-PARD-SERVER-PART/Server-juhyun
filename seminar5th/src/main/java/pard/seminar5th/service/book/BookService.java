package pard.seminar5th.service.book;

import jakarta.transaction.Transactional;
import org.apache.el.parser.AstFalse;
import org.springframework.stereotype.Service;
import pard.seminar5th.dto.book.BookCreateRequest;
import pard.seminar5th.dto.bookLoanRequest.BookLoanRequest;
import pard.seminar5th.entity.book.Book;
import pard.seminar5th.entity.user.User;
import pard.seminar5th.entity.userLoanHistory.UserLoanHistory;
import pard.seminar5th.repository.book.BookRepository;
import pard.seminar5th.repository.user.UserRepository;
import pard.seminar5th.repository.userLoanHistoryRepository.UserLoanHistoryRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
//    UserLoanHistoryRepositry에 접근을 해야되니까 의존성을 추가해줍니다~
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;


    public BookService (BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository,UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

//    DTO에서 entity로 바꾸는 방법
    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request){
        //findByName은 없기에 만들어줘야 한다. bookRepository로 만들어서 bookrepository에 옮겨서 만들어야 한다
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false)){
            throw new IllegalArgumentException("이미 대출중인 책입니다.");
        }
        User user = userRepository.findById(request.getUserId()).orElseThrow(IllegalArgumentException::new);
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }
}
