package africa.semicolon.Services;

import africa.semicolon.Data.Models.Comment;
import africa.semicolon.Data.Models.Post;
import africa.semicolon.dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService {
    void createPost(CreatePostRequest createPostRequest);
    void updatedPost(CreatePostRequest createPostRequest);
    void deletePost(String id);
    Post viewPost(String id);
    List<Post> viewAll();
    void addComment(String id, Comment comment);
}
