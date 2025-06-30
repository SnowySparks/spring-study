package project.simpleboard.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.simpleboard.post.db.PostEntity;
import project.simpleboard.post.dto.PostDTO;
import project.simpleboard.reply.dto.ReplyDTO;
import project.simpleboard.reply.service.ReplyConverter;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostConverter {

    private final ReplyConverter replyConverter;

    public PostDTO toDTO(PostEntity postEntity) {

        List<ReplyDTO> replyDTOList = postEntity.getReplyList().stream()
                .map(replyConverter::toDTO)
                .toList();

        return PostDTO.builder()
                .id(postEntity.getId())
                .userName(postEntity.getUserName())
                .status(postEntity.getStatus())
                .email(postEntity.getEmail())
                .password(postEntity.getPassword())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .postedAt(postEntity.getPostedAt())
                .boardId(postEntity.getBoard().getId())
                .replyList(replyDTOList)
                .build();
    }
}
