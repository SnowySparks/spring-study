package project.simpleboard.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.simpleboard.board.db.BoardEntity;
import project.simpleboard.board.dto.BoardDTO;
import project.simpleboard.post.service.PostConverter;

@Service
@RequiredArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;

    public BoardDTO ToDto(BoardEntity boardEntity) {

        var postList = boardEntity.getPostList()
                .stream()
                .map(postConverter::toDTO).toList();

        return BoardDTO.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(postList)
                .build();
    }
}
