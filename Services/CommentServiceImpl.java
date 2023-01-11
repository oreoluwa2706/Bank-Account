package africa.semicolon.Services;


import africa.semicolon.Data.Models.Comment;
import africa.semicolon.Data.Repositories.CommentRepository;
import africa.semicolon.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository ;
    @Autowired
    private PostService postService;

    @Override
    public void createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();
        comment.setCommentBody(createCommentRequest.getCommentBody());
        comment.setCommenterName(createCommentRequest.getCommenterName());
        Comment savedComment = commentRepository.save(comment);
        postService.addComment(createCommentRequest.getPostId(), savedComment);



    }

    @Override
    public void updateComment(CreateCommentRequest createCommentRequest) {
    }



    @Override
    public void delete(String postId) {
    }

    @Override
    public Comment viewComment(String postId) {

        return commentRepository.findCommentByPostId(postId);
    }

    @Override
    public List<Comment> viewAll() {
        return commentRepository.findAll();
    }
}
