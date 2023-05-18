package com.app.helpchef.Service;

import com.app.helpchef.Model.Comment;
import com.app.helpchef.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment findCommentById(long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + commentId + " not exist"));
    }

    public Comment updateComment(long commentId, Comment commentDetails) {
        Comment updateComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + commentId + " not exist"));

        updateComment.setNick(commentDetails.getNick());
        updateComment.setContent(commentDetails.getContent());
        updateComment.setCommentDate(commentDetails.getCommentDate());

        return commentRepository.save(updateComment);
    }

    public void deleteComment(long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + commentId + " not exist"));

        commentRepository.delete(comment);
    }
}
