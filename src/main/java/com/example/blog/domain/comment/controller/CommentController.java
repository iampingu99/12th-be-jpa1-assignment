package com.example.blog.domain.comment.controller;

import com.example.blog.domain.comment.doamin.Comment;
import com.example.blog.domain.comment.dto.CommentRequest;
import com.example.blog.domain.comment.dto.CommentUpdateRequest;
import com.example.blog.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CommentRequest request){
        Comment response = commentService.create(request);
        return ResponseEntity.ok().body(response.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                    @RequestBody CommentUpdateRequest request){
        commentService.update(id, request);
        return ResponseEntity.ok().body("수정이 완료되었습니다.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id,
                                    @RequestBody CommentUpdateRequest request){
        commentService.delete(id, request);
        return ResponseEntity.ok().body("삭제가 완료되었습니다.");
    }
}
