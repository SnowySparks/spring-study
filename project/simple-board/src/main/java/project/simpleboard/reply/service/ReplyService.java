package project.simpleboard.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.simpleboard.post.db.PostRepository;
import project.simpleboard.reply.db.ReplyEntity;
import project.simpleboard.reply.db.ReplyRepository;
import project.simpleboard.reply.dto.CreateReplyDTO;
import project.simpleboard.reply.dto.ReplyDTO;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;
    private final ReplyConverter replyConverter;

    @PostMapping("/")
    public ReplyDTO create(CreateReplyDTO createReplyDTO) {

        var post = postRepository.findById(createReplyDTO.getPostId()).orElseThrow(
                () -> new RuntimeException("게시물이 존재하지 않아요." + createReplyDTO.getPostId())
        );

        var entity = ReplyEntity.builder()
                .post(post)
                .userName(createReplyDTO.getUserName())
                .password(createReplyDTO.getPassword())
                .title(createReplyDTO.getTitle())
                .status("REGISTERED")
                .content(createReplyDTO.getContent())
                .repliedAt(LocalDateTime.now())
                .build();

        return replyConverter.toDTO( replyRepository.save(entity) );
    }

}