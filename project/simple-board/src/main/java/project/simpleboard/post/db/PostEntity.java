package project.simpleboard.post.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import project.simpleboard.board.db.BoardEntity;
import project.simpleboard.reply.db.ReplyEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "board_id")
    @JsonIgnore
    @ToString.Exclude
    private BoardEntity board; // system상 board_id가 된다

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 4)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime postedAt;

    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<ReplyEntity> replyList = List.of();

}
