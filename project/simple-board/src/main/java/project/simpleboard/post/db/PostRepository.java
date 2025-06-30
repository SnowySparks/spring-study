package project.simpleboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    Optional<PostEntity> findByIdAndStatusOrderByIdDesc(Long id, String status);
}
