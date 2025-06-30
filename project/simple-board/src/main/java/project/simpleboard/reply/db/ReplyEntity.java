package project.simpleboard.reply.db;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import project.simpleboard.post.db.PostEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    @JsonIgnore
    @ToString.Exclude
    private PostEntity post;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, length = 4)
    private String password;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime repliedAt;
}