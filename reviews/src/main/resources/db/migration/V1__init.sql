CREATE TABLE t_users (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE t_reviews (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           userId BIGINT NOT NULL,
                           productId BIGINT NOT NULL,
                           rating INT NOT NULL,
                           comment TEXT,
                           createdAt DATETIME NOT NULL,
                           CONSTRAINT fk_reviews_user FOREIGN KEY (userId) REFERENCES t_users(id) ON DELETE CASCADE
);

