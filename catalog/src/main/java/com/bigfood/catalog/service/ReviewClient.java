package com.bigfood.catalog.service;

import com.bigfood.catalog.entity.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review", url = "http://localhost:8082")
public interface ReviewClient {

    @GetMapping("/reviews/{id}")
    ReviewDTO getReviewsByProductId(@PathVariable("id") Long productId);
}
