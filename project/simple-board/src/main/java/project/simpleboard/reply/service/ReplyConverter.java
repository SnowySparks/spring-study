package project.simpleboard.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.simpleboard.crud.Converter;
import project.simpleboard.post.db.PostRepository;
import project.simpleboard.reply.db.ReplyEntity;
import project.simpleboard.reply.dto.ReplyDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDTO, ReplyEntity> {

    private final PostRepository postRepository;


    @Override
    public ReplyEntity toEntity(ReplyDTO replyDTO) {

        var postEntity = postRepository.findById(replyDTO.getPostId());
        return ReplyEntity.builder()
                .id(replyDTO.getId())
                .post(postEntity.orElse(null))
                .status(replyDTO.getStatus() != null ?  replyDTO.getStatus() : "REGISTERED")
                .title(replyDTO.getTitle())
                .content(replyDTO.getContent())
                .userName(replyDTO.getUserName())
                .password(replyDTO.getPassword())
                .build();
    }

    @Override
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
