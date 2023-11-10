package pard.seminar5th.controller.book;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pard.seminar5th.dto.book.BookCreateRequest;
import pard.seminar5th.dto.bookLoanRequest.BookLoanRequest;
import pard.seminar5th.service.book.BookService;

@RestController
public class BookController {
    private final BookService bookService;

    //service가 한개만 있으면 autowired없어도 스프링이 한개만 있으면 알아서 가져다 사용한다
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/book") //request는 dto로 service에 전달된다
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
        public void loanBook(@RequestBody BookLoanRequest request){
            bookService.loanBook(request);
        }
    }

