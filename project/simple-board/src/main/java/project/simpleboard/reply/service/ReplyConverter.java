package project.simpleboard.reply.service;

import org.springframework.stereotype.Service;
import project.simpleboard.reply.db.ReplyEntity;
import project.simpleboard.reply.dto.ReplyDTO;

@Service
public class ReplyConverter {

    public ReplyDTO toDTO(ReplyEntity replyEntity) {
        return ReplyDTO.builder()
                .id(replyEntity.getId())
                .content(replyEntity.getContent())
                .postId(replyEntity.getPost().getId())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .title(replyEntity.getTitle())
                .repliedAt(replyEntity.getRepliedAt())
                .status(replyEntity.getStatus())
                .build();
    }
}
