package com.bigfood.review.repository;

import com.bigfood.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);

    // Найти все отзывы по пользователю
    List<Review> findByUserId(Long userId);
}
