package study.memorydb.user.model;

import lombok.*;
import study.memorydb.entity.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {
    private String name;
    private int score;
}
