package africa.semicolon.Data.Repositories;

import africa.semicolon.Data.Models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
Post findPostById(String id);
//Post updatePost(Post post);


//Post findByTitle(String title);

}
