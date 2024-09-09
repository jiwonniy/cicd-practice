package com.cicd.server.user;

import com.cicd.server.global.LocalDummyDataInit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@LocalDummyDataInit
@Order(1)
public class UserInitializer implements ApplicationRunner {
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) {

        if (userRepository.count() > 0) {
            log.info("[User]더미 데이터 존재");
        } else {
            List<User> memberList = new ArrayList<>();

            User DUMMY_USER1 = User.builder()
                    .nickname("user1")
                    .goal("cicd test")
                    .build();

            User DUMMY_USER2 = User.builder()
                    .nickname("user2")
                    .goal("cicd test")
                    .build();

            User DUMMY_USER3 = User.builder()
                    .nickname("user3")
                    .goal("cicd test")
                    .build();

            memberList.add(DUMMY_USER1);
            memberList.add(DUMMY_USER2);
            memberList.add(DUMMY_USER3);

            userRepository.saveAll(memberList);
        }
    }

}
