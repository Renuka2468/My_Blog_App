package io.mountblue.controller.api;

import io.mountblue.entity.Post;
import io.mountblue.repository.PostRepository;
import io.mountblue.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RestControllers {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @GetMapping("/api")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/api/posts/{postId}")
    public Post getPostId(@PathVariable("postId") Long postId) {
        return postRepository.findById(postId).get();
    }

//    @GetMapping("/api/posts/search")
//    public Page<Post> searchPost(@RequestParam("searchQuery") String searchQuery, Pageable pageable) {
//        return postRepository.searchPosts(searchQuery, pageable);
//    }


    @GetMapping("/api/posts/search/filter")
    public List<Post> searchPost(Model model, @RequestParam(required = false) String[] author, @RequestParam(required = false) String[] tag, @RequestParam(required = false) Map<String, String> queryString,  Pageable pageable) {
        //@RequestParam(required = false) String[] author,
        //                               @RequestParam(required = false) String[] tag,
        //                               @RequestParam(required = false) Map<String,String> queryString
        System.out.print("render /search");

        Page<Post> postPage = postService.displayPosts(queryString, author, tag);
        List<Post> posts = postPage.getContent();


        return posts;
    }

}
