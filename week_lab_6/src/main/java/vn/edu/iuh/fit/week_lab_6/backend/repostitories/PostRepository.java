package vn.edu.iuh.fit.week_lab_6.backend.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.week_lab_6.backend.entities.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByPost(Post post);
}