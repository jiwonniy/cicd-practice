package com.cicd.server.review;

import com.cicd.server.global.dto.ResponseTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "ReviewController", description = "ReviewController 관련 API")
@Slf4j
@RestController
@RequestMapping("/cicdtest")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @Operation(summary = "모든 리뷰 조회", description = "모든 리뷰 조회")
    @GetMapping("/reviews")
    public ResponseEntity<ResponseTemplate<Object>> getAllReviews() {

        List<ReviewResponse> response = reviewService.getAllReviews();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseTemplate.from(response));
    }

    @Operation(summary = "하나의 리뷰 조회", description = "하나의 리뷰 조회")
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<ResponseTemplate<Object>> getReview(
            @PathVariable Long reviewId) {

        ReviewResponse response = reviewService.getReview(reviewId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseTemplate.from(response));
    }

}
