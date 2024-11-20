package com.bigfood.review.service;

import com.bigfood.review.entity.Review;
import com.bigfood.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Создание отзыва
    public Review createReview(Review review) {
        review.setCreatedAt(LocalDateTime.now());  // Устанавливаем дату создания
        return reviewRepository.save(review);
    }

    // Получение всех отзывов по продукту
    public List<Review> getReviewsByProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    // Получение всех отзывов по пользователю
    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    // Получить отзыв по ID
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    // Удаление отзыва
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}