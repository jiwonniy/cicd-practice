package com.cicd.server.review;

import java.util.ArrayList;
import java.util.List;

import com.cicd.server.global.LocalDummyDataInit;
import com.cicd.server.user.User;
import com.cicd.server.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;


@Slf4j
@RequiredArgsConstructor
@LocalDummyDataInit
@Order(2)
public class ReviewInitializer implements ApplicationRunner {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (reviewRepository.count() > 0) {
            log.info("[Review] 더미 데이터 존재");
        } else {
            User user1 = userRepository.findByNickname("user1");
            User user2 = userRepository.findByNickname("user2");
            User user3 = userRepository.findByNickname("user3");

            List<Review> reviewList = new ArrayList<>();

            Review DUMMY_REVIEW1 = Review.builder()
                    .title("this is title")
                    .content("content")
                    .user(user1)
                    .build();
            Review DUMMY_REVIEW2 = Review.builder()
                    .title("this is title")
                    .content("content")
                    .user(user2)
                    .build();
            Review DUMMY_REVIEW3 = Review.builder()
                    .title("this is title")
                    .content("content")
                    .user(user3)
                    .build();
            
            reviewList.add(DUMMY_REVIEW1);
            reviewList.add(DUMMY_REVIEW2);
            reviewList.add(DUMMY_REVIEW3);

            reviewRepository.saveAll(reviewList);
        }
    }
}
