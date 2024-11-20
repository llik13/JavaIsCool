CREATE TABLE IF NOT EXISTS t_category (
    CategoryId BIGINT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Description TEXT,
    ImageUrl VARCHAR(255)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE t_product
ADD COLUMN CategoryId BIGINT,
ADD CONSTRAINT FK_t_product_category
FOREIGN KEY (CategoryId) REFERENCES t_category(CategoryId);