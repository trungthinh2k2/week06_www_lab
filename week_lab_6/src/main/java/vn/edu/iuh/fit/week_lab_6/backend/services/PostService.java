package vn.edu.iuh.fit.week_lab_6.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week_lab_6.backend.entities.Post;
import vn.edu.iuh.fit.week_lab_6.backend.repostitories.PostRepository;

import java.util.List;
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Page<Post> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        List<Post> posts = postRepository.findAllByPost(null);
        return postRepository.findAll(pageable);
//        return new PageImpl<>(posts, pageable, posts.size());
    }
}