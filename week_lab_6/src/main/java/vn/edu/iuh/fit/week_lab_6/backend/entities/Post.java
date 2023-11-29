package vn.edu.iuh.fit.week_lab_6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "post")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
    @Column(name = "meta_title", columnDefinition = "varchar(100)")
    private String metaTitle;
    private boolean published;
    @Column(name = "published_at")
    private LocalDateTime publishedAt;
    @Column(columnDefinition = "TINYTEXT")
    private String summary;
    private String title;
    @Column(name = "update_at", columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name="author_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post post;

    @OneToMany(mappedBy = "post")
    private Set<Post> posts;
    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments;

    public Post(String content, String metaTitle, LocalDateTime publishedAt, String summary, String title, LocalDateTime updatedAt, User user, Post post) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.metaTitle = metaTitle;
        this.published = true;
        this.publishedAt = publishedAt;
        this.summary = summary;
        this.title = title;
        this.updatedAt = updatedAt;
        this.user = user;
        this.post = post;
    }
}
