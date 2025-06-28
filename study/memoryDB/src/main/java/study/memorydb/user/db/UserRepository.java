package study.memorydb.user.db;

import org.springframework.stereotype.Repository;
import study.memorydb.db.SimpleDataRepository;
import study.memorydb.user.model.UserEntity;

import java.util.List;

@Repository
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    public List<UserEntity> findAllScoreGreaterThan(int score) {
        return this.findAll().stream()
                .filter(user -> user.getScore() >= score)
                .toList();
    }

}
