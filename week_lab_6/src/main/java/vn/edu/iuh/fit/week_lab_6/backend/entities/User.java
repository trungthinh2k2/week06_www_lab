package vn.edu.iuh.fit.week_lab_6.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Table(name = "user")
@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "firstName", nullable = false, columnDefinition = "varchar(50)")
    private String firstName;
    @Column(name = "middleName", nullable = false, columnDefinition = "varchar(50)")
    private String middleName;
    @Column(name = "lastName", nullable = false, columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "mobile", nullable = false, columnDefinition = "varchar(15)")
    private String mobile;
    @Column(name = "email", nullable = false, columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "passwordHash", nullable = false, columnDefinition = "varchar(32)")
    private String passwordHash;
    @Column(name = "registeredAt", nullable = false, columnDefinition = "DATETIME")
    private LocalDate registeredAt;
    @Column(name = "lastLogin", nullable = false, columnDefinition = "DATETIME")
    private LocalDate lastLogin;
    @Column(columnDefinition = "TINYTEXT")
    private String intro;
    @Column(columnDefinition = "text")
    private String profile;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    private List<PostComment> postComments;

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, LocalDate registeredAt, LocalDate lastLogin, String intro, String profile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
    }

    public User(long id) {
        this.id = id;
    }

    public User() {
    }
}
