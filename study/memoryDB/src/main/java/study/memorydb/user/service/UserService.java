package study.memorydb.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.memorydb.user.db.UserRepository;
import study.memorydb.user.model.UserEntity;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }


    public void delete(Long id) {
        userRepository.delete(id);
    }

    public List<UserEntity> filterUpScore(int score) {
        return userRepository.findAllScoreGreaterThan(score);
    }
}
