package vn.edu.iuh.fit.week_lab_6.backend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.week_lab_6.backend.entities.Post;
import vn.edu.iuh.fit.week_lab_6.backend.entities.User;
import vn.edu.iuh.fit.week_lab_6.backend.repostitories.PostRepository;

import java.time.LocalDateTime;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post post, HttpSession session){
        post.setCreatedAt(LocalDateTime.now());
        post.setPublishedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setUser((User) session.getAttribute("user"));
        post.setPublished(true);
        postRepository.save(post);
        return "redirect:user/logIn";
    }
}
