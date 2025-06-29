package study.memorydb.user.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.memorydb.user.model.UserEntity;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public List<UserEntity> findAllByScoreGreaterThan(int score);

    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int minScore, int maxScore);

    @Query(
            value = "select * from user as u where u.score >= :min AND u.score <= :max",
            nativeQuery = true
    )
    List<UserEntity> score(@Param(value = "min") int minScore, @Param(value = "max") int maxScore);
}
