package vn.edu.iuh.fit.week_lab_6.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.week_lab_6.entities.PostComment;
import vn.edu.iuh.fit.week_lab_6.entities.User;
import vn.edu.iuh.fit.week_lab_6.repostitories.PostCommentRepository;
import vn.edu.iuh.fit.week_lab_6.repostitories.PostRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class PostCommentController {
    @Autowired
    private PostCommentRepository postCommentRepository;
    @Autowired
    private PostRepository postRepository;
    @PostMapping("/addComment")
    public String addComment(HttpSession session, @RequestParam("postId") Long postId, @ModelAttribute("comment") PostComment postComment, Model model){
        postComment.setCreatedAt(LocalDateTime.now());
        postComment.setPublished(true);
        postComment.setPublishedAt(LocalDateTime.now());
        postComment.setPost(postRepository.findById(postId).get());
        postComment.setUser((User) session.getAttribute("user"));
        postCommentRepository.save(postComment);
        return "redirect:user/logIn";
    }
}