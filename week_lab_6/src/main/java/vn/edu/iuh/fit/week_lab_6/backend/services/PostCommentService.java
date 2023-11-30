package vn.edu.iuh.fit.week_lab_6.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week_lab_6.backend.entities.PostComment;
import vn.edu.iuh.fit.week_lab_6.backend.repostitories.PostCommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostCommentService {
    private final PostCommentRepository postCommentRepository;

    public List<PostComment> getAll() {
        return postCommentRepository.findAll();
    }

    public void insert(PostComment postComment) {
        postCommentRepository.save(postComment);
    }

}
