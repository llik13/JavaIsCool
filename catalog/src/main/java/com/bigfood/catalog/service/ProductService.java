package com.bigfood.catalog.service;

import com.bigfood.catalog.entity.Category;
import com.bigfood.catalog.entity.Product;
import com.bigfood.catalog.repository.CategoryRepository;
import com.bigfood.catalog.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewClient reviewClient;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Получить все продукты
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Получить продукт по ID

    public Optional<ProductReviewDto> getProductById(Long productId, Long reviewId) {
        // Отримуємо відгук
        var review = reviewClient.getReviewsByProductId(reviewId);

        // Отримуємо продукт з Optional
        Optional<Product> optionalProduct = productRepository.findById(productId);

        // Якщо продукт знайдений, створюємо ProductReviewDto
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ProductReviewDto productReviewDto = new ProductReviewDto(product, review);
            return Optional.of(productReviewDto);
        }

        // Якщо продукт не знайдений, повертаємо пусте Optional
        return Optional.empty();
    }

    // Создать новый продукт
    public Product createProduct(Product product) {
        // Найдем категорию по ID и установим ее в продукт
        Category category = categoryRepository.findById(product.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategoryId(category.getId());  // Устанавливаем только ID
        return productRepository.save(product);
    }

    // Обновить существующий продукт
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Product with id " + id + " not found");
        }
    }

    // Удалить продукт
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Product with id " + id + " not found");
        }
    }
}