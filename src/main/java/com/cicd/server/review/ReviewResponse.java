package com.cicd.server.review;

public record ReviewResponse(
        Long reviewId,
        String title,
        String content
) {
    public static ReviewResponse from(Review review) {
        return new ReviewResponse(
                review.getId(), review.getTitle(), review.getContent());
    }
}
