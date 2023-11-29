package vn.edu.iuh.fit.week_lab_6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", columnDefinition = "varchar(50)")
    private String firstName;
    @Column(name = "middle_name", columnDefinition = "varchar(50)")
    private String middleName;
    @Column(name = "last_name", columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "mobile", columnDefinition = "varchar(15)")
    private String mobile;
    @Column(name = "email", columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "password_hash", columnDefinition = "varchar(32)")
    private String passwordHash;
    @Column(name = "registered_at", columnDefinition = "DATETIME")
    private LocalDateTime registeredAt;
    @Lob
    @Column(columnDefinition = "text")
    private String intro;
    @Column(name = "last_login", columnDefinition = "DATETIME")
    private LocalDateTime lastLogin;
    @Lob
    @Column(columnDefinition = "text")
    private String profile;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> post;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<PostComment> comments;

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, String intro, String profile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = LocalDateTime.now();
        this.intro = intro;
        this.profile = profile;
    }
}

