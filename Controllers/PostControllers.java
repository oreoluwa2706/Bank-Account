package africa.semicolon.Controllers;

import africa.semicolon.Data.Models.Post;
import africa.semicolon.Services.PostService;
import africa.semicolon.Services.PostServiceImpl;
import africa.semicolon.dtos.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostControllers {
    @Autowired
    private PostService postService;
    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";
    }
    @GetMapping("/post/{id}")
    public Post viewPost(@PathVariable String id){

        return postService.viewPost(id);
    }
    //@PutMapping("/post/{id}")
    //public void updatedPost(@PathVariable String id, @RequestBody String title, String body){
       // post.setId(id);
     //   return postService.updatedPost(title);
   // }
    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable String id){
        postService.deletePost(id);
    }
    }

