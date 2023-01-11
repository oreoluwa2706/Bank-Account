package africa.semicolon.Services;


import africa.semicolon.Data.Models.Comment;
import africa.semicolon.Data.Models.Post;
import africa.semicolon.Data.Repositories.PostRepository;
import africa.semicolon.dtos.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;
    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setBody(createPostRequest.getBody());
        post.setTitle(createPostRequest.getTitle());
        postRepository.save(post);



    }

    @Override
    public void updatedPost(CreatePostRequest createPostRequest) {
       Post post = new Post();
        //postRepository.updatePost(post);
    }

    @Override
    public void deletePost(String id) {
        postRepository.deleteById(id);

    }

    @Override
    public Post viewPost(String id) {

        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> viewAll() {

        return postRepository.findAll();
    }

    @Override
    public void addComment(String postId, Comment comment) {
        Post savedPost = postRepository.findPostById(postId);
        //Comment savedPost = commentRepository.findById(postId);


        savedPost.getComments().add(comment);
        postRepository.save(savedPost);
    }
}
