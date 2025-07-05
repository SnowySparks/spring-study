package project.simpleboard.reply.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.simpleboard.crud.CRUDApiAbstractController;
import project.simpleboard.reply.db.ReplyEntity;
import project.simpleboard.reply.dto.ReplyDTO;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyController extends CRUDApiAbstractController<ReplyDTO, ReplyEntity> {}


