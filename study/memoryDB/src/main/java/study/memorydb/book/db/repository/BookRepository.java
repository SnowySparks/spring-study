package study.memorydb.book.db.repository;

import org.springframework.stereotype.Repository;
import study.memorydb.book.db.entity.BookEntity;
import study.memorydb.db.SimpleDataRepository;

@Repository
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {

}
