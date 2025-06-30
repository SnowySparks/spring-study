package project.simpleboard.board.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import project.simpleboard.post.db.PostEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String boardName;

    private String status;

    @OneToMany(mappedBy = "board")
    @Builder.Default
    @OrderBy("id desc")
    private List<PostEntity> postList = List.of();
}
