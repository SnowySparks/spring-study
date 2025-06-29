package study.memorydb.user.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import study.memorydb.user.model.UserEntity;
import study.memorydb.user.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor // 생성자 주입
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;


    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }


    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
//        userService.delete(id);
    }


    @GetMapping("/id/{id}")
    public UserEntity findById(@PathVariable Long id) {
        return userService.findById(id).orElse(null);
    }

    @GetMapping("/score")
    public List<UserEntity> score(
            @RequestParam int score
    ) {
        return userService.filterUpScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> minMax(
            @RequestParam int min,
            @RequestParam int max
    ) {
        return userService.filterRangeScore(min, max);
    }


}
