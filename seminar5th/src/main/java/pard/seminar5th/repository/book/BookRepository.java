package pard.seminar5th.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.seminar5th.entity.book.Book;

import java.util.Optional;

//Long은 대문자여야 한다
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String BookName); //Optional이 null값도 자동으로 감싸서 처리해준다
}
