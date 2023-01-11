package africa.semicolon.Data.Repositories;

import africa.semicolon.Data.Models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Comment findCommentByPostId(String postId);

}
