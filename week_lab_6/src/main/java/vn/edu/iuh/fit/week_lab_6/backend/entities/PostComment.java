package vn.edu.iuh.fit.week_lab_6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Getter @Setter
@Table(name = "post_comment")
@AllArgsConstructor
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean published;
    @Lob
    @Column(columnDefinition = "text")
    private String content;
    @Column(name = "published_at", columnDefinition = "DATETIME")
    private LocalDateTime publishedAt;
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment postComment;
    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    private Set<PostComment> postComments;

    public PostComment(String title, String content, LocalDateTime publishedAt, Post post, User user, PostComment postComment) {
        this.title = title;
        this.published = true;
        this.content = content;
        this.publishedAt = publishedAt;
        this.createdAt = LocalDateTime.now();
        this.post = post;
        this.user = user;
        this.postComment = postComment;
    }
}
