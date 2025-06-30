package project.simpleboard.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.simpleboard.board.db.BoardEntity;
import project.simpleboard.board.db.BoardRepository;
import project.simpleboard.board.dto.BoardDTO;
import project.simpleboard.board.dto.CreateBoardDTO;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;


    public BoardDTO create(
            CreateBoardDTO createBoardDTO
    ) {
        var newBoardEntity = BoardEntity.builder()
                .boardName(createBoardDTO.getBoardName())
                .status("REGISTERED")
                .build();

        return boardConverter.ToDto(boardRepository.save(newBoardEntity));
    }

    public BoardDTO view(Long id) {
        return boardConverter.ToDto(boardRepository.findById(id).orElseThrow());
    }
}
