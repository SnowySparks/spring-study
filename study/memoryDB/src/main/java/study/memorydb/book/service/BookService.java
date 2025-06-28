package study.memorydb.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.memorydb.book.db.entity.BookEntity;
import study.memorydb.book.db.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    //create, update
    public BookEntity save(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

//    findall

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

}
