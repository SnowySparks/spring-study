package project.simpleboard.board.service;

import org.springframework.stereotype.Service;
import project.simpleboard.board.db.BoardEntity;
import project.simpleboard.board.dto.BoardDTO;
import project.simpleboard.post.service.PostConverter;

@Service
public class BoardConverter {

    private PostConverter postConverter;

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
