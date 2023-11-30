package vn.edu.iuh.fit.week_lab_6.backend;

import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.loremipsum.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.week_lab_6.backend.entities.*;
import vn.edu.iuh.fit.week_lab_6.backend.repostitories.*;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;

@SpringBootApplication
public class WeekLab6Application {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;


    public static void main(String[] args) {
        SpringApplication.run(WeekLab6Application.class, args);
    }

    @Bean
    CommandLineRunner initData(){
        return args -> {
            User userAdmin = new User("Trần", "Lâm Trung", "Thịnh", "0965355043", "trungthinh@gmail.com", "08062002", "Hello everyone", "Trần Lâm Trung Thịnh - IUH");
            userRepository.save(userAdmin);
            Faker faker = new Faker(new Locale("vi", "VN"));
            Random random = new Random();
            Device devices = faker.device();
            String[] ho = {"Nguyễn", "Trần", "Lê", "Lý", "Huỳnh", "Ngô"};
            String[] tenLot = {"Quốc", "Thanh", "Nhật"};
            String[] ten = {"Thịnh", "Phong", "Toàn", "Tuấn", "Thuận"};
            for (int i = 2; i <= 100; i++) {
                User user = new User(ho[random.nextInt(6)], tenLot[random.nextInt(3)], ten[random.nextInt(5)],
                        "09"+random.nextLong(10000000L,99999999L),"user"+i+"@gmail.com",
                        "123", LoremIpsum.createParagraph(50), LoremIpsum.createParagraph(100));
                userRepository.save(user);
            }
            for (int i = 1; i <= 200; i++) {
                Post post = new Post(LoremIpsum.createParagraph(100), "post"+i, LocalDateTime.now(), "summary of post "+i, "post #"+i, LocalDateTime.now(), userRepository.findById(random.nextLong(1,101)).get(), null);
                postRepository.save(post);
            }
            for (int i = 1; i <= 500; i++) {
                PostComment postComment = new PostComment("Comment #"+i, LoremIpsum.createParagraph(50), LocalDateTime.now(), postRepository.findById(random.nextLong(1, 201)).get(), userRepository.findById(random.nextLong(1,101)).get(), null);
                postCommentRepository.save(postComment);
            }
        };
    }
}
