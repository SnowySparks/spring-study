package project.simpleboard.post.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.simpleboard.board.db.BoardRepository;
import project.simpleboard.common.Api;
import project.simpleboard.common.Pagination;
import project.simpleboard.post.db.PostEntity;
import project.simpleboard.post.db.PostRepository;
import project.simpleboard.post.dto.CreatePostDTO;
import project.simpleboard.post.dto.PostDTO;
import project.simpleboard.post.dto.PostViewRequestDTO;
import project.simpleboard.reply.db.ReplyRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final PostConverter postConverter;

    public PostDTO createPost(CreatePostDTO createPostDTO) {

        var boardEntity = boardRepository.findById(createPostDTO.getBoardId()).get();


        var newPost = PostEntity.builder()
                .board(boardEntity)
                .userName(createPostDTO.getUserName())
                .password(createPostDTO.getPassword())
                .email(createPostDTO.getEmail())
                .status("REGISTERED")
                .title(createPostDTO.getTitle())
                .content(createPostDTO.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postConverter.toDTO(postRepository.save(newPost));
    }

    public PostDTO view(@Valid PostViewRequestDTO postViewDTO) {

        // 찾기
        PostEntity post = postRepository.findByIdAndStatusOrderByIdDesc(postViewDTO.getPostId(),"REGISTERED").orElseThrow(
                () -> new RuntimeException("해당 게시글이 존재하지 않습니다 : " + postViewDTO.getPostId())
        );

        if (!post.getPassword().equals(postViewDTO.getPassword())) {
            var format = "패스워드가 일치하지 않습니다 : %s vs %s";
            throw new RuntimeException(String.format(format, postViewDTO.getPassword(), postViewDTO.getPassword()));
        }

        var replyList = replyRepository.findAllByPostIdAndStatusOrderByIdDesc(post.getId(), "REGISTERED");
        post.setReplyList(replyList);

        return postConverter.toDTO(postRepository.save(post));
    }

    public Api<List<PostDTO>> viewAllPost(Pageable pageable) {

        Page<PostEntity> list;
        list = postRepository.findAll(pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber()) // 현재 페이지
                .size(list.getSize()) // 요청 사이즈 개수 (한 페이지당 몇 개 요청한건가)
                .currentElements(list.getNumberOfElements()) // 현재 페이지 데이터 수
                .totalElements(list.getTotalElements()) // 전체 데이터 수
                .totalPages(list.getTotalPages()) // 전체 페이지 수
                .build();

        List<PostDTO> postDTOList = list.getContent().stream().map(postConverter::toDTO).toList();

        var response = Api.<List<PostDTO>> builder()
                .body(postDTOList)
                .pagination(pagination)
                .build();


        return response;
    }

    public Long delete(PostViewRequestDTO postViewDTO) {
        PostEntity post = postRepository.findById(postViewDTO.getPostId()).orElseThrow(
                () -> new RuntimeException("해당 게시글이 존재하지 않습니다 : " + postViewDTO.getPostId())
        );

        if (!post.getPassword().equals(postViewDTO.getPassword())) {
            var format = "패스워드가 일치하지 않습니다 : %s vs %s";
            throw new RuntimeException(String.format(format, postViewDTO.getPassword(), postViewDTO.getPassword()));
        }

        post.setStatus("UNREGISTERED");
        postRepository.save(post);

        return post.getId();
    }
}
