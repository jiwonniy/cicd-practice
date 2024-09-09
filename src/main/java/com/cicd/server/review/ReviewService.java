package com.cicd.server.review;

import com.cicd.server.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();

        List<ReviewResponse> responses = reviews.stream()
                .map(ReviewResponse::from)
                .toList();

        return responses;
    }
}
