package study.memorydb.book.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.memorydb.book.db.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
