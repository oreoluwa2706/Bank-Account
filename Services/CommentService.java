package africa.semicolon.Services;

import africa.semicolon.Data.Models.Comment;
import africa.semicolon.dtos.requests.CreateCommentRequest;

import java.util.List;

public interface CommentService {

    void createComment(CreateCommentRequest createCommentRequest);
    void updateComment(CreateCommentRequest createCommentRequest );
    void delete(String postId);
    Comment viewComment(String postId);
    List<Comment> viewAll();
}
