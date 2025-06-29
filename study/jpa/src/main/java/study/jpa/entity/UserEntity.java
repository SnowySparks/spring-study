package study.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.AUTO)  // ID 자동생성 방식
    private Long id;

    private String name;

    private String email;

    private Integer age;
}
