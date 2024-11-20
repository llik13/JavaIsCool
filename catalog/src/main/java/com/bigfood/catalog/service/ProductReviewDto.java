package com.bigfood.catalog.service;

import com.bigfood.catalog.entity.Product;
import com.bigfood.catalog.entity.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewDto {
    private Product product;
    private ReviewDTO review;
}
