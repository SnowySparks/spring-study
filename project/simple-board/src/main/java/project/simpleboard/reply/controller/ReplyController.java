package project.simpleboard.reply.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.simpleboard.reply.db.ReplyEntity;
import project.simpleboard.reply.dto.CreateReplyDTO;
import project.simpleboard.reply.dto.ReplyDTO;
import project.simpleboard.reply.service.ReplyService;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("")
    public ReplyDTO create(@Valid  @RequestBody CreateReplyDTO createReplyDTO) {
        return replyService.create(createReplyDTO);
    }
}
