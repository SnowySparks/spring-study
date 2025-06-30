package project.simpleboard.board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.simpleboard.board.db.BoardEntity;
import project.simpleboard.board.dto.BoardDTO;
import project.simpleboard.board.dto.CreateBoardDTO;
import project.simpleboard.board.service.BoardService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<BoardDTO> createBoard(
            @Valid @RequestBody CreateBoardDTO createBoardDTO
    ) {
        var result = boardService.create(createBoardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/id/{id}")
    public BoardDTO view(
            @PathVariable Long id
    ) {
        var result = boardService.view(id);
        log.info(" result :  {}", result);
        return result;
    }
}
