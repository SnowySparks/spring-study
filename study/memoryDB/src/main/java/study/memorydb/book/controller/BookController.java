package study.memorydb.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import study.memorydb.book.db.entity.BookEntity;
import study.memorydb.book.db.repository.BookRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final BookRepository bookRepository;

    @PostMapping("")
    public BookEntity save(@RequestBody BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }
}
