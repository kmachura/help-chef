package com.app.helpchef.Controller;

import com.app.helpchef.Model.Comment;
import com.app.helpchef.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> geCommentById(@PathVariable long commentId) {
        return ResponseEntity.ok(commentService.findCommentById(commentId));
    }

    @PutMapping("/editRecipe/{recipeId}")
    public ResponseEntity<Comment> updateRecipe(@PathVariable long commentId, @RequestBody Comment commentDetails) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentDetails));
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
