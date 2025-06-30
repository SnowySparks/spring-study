package project.simpleboard.reply.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {


    List<ReplyEntity> findAllByPostIdAndStatusOrderByIdDesc(Long userId, String status);
}
