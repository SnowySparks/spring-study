package project.simpleboard.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.simpleboard.crud.CRUDAbstractService;
import project.simpleboard.reply.db.ReplyEntity;

import project.simpleboard.reply.dto.ReplyDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyService extends CRUDAbstractService<ReplyDTO, ReplyEntity> {

}