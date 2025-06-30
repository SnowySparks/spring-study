package project.simpleboard.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import project.simpleboard.common.Api;
import project.simpleboard.post.db.PostEntity;
import project.simpleboard.post.dto.CreatePostDTO;
import project.simpleboard.post.dto.PostDTO;
import project.simpleboard.post.dto.PostViewRequestDTO;
import project.simpleboard.post.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostDTO savePost(@Valid @RequestBody CreatePostDTO createPostDTO) {
        return postService.createPost(createPostDTO);
    }


    @GetMapping("/view")
    public PostDTO viewPost(@Valid @RequestBody PostViewRequestDTO postViewDTO) {

        return postService.view(postViewDTO);
    }

    @GetMapping("/all")
    public Api<List<PostDTO>> viewAllPost(
            @PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.DESC ) Pageable pageable
    ) {
        return postService.viewAllPost(pageable);
    }

    @DeleteMapping("/delete")
    public Long delete(@Valid @RequestBody PostViewRequestDTO postViewDTO) {
        return postService.delete(postViewDTO);
    }

}
