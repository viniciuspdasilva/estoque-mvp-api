package br.com.pucrs.estoque_mvp_api.application.domain.model;

import java.math.BigDecimal;

public record Product(
        Integer id,
        String title,
        BigDecimal price,
        String description,
        String category,
        String image,
        Integer stock,
        boolean active
) {

    public Product {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be null or zero or negative");
        }
        if (stock == null || stock < 0) {
            throw new IllegalArgumentException("Stock cannot be null or negative");
        }
    }

    public boolean isActive() {
        return stock > 0 && active;
    }

    public boolean isOutOfStock() {
        return stock <= 0;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public boolean isInactive() {
        return !active;
    }

    public boolean isInStock() {
        return stock > 0;
    }

    public boolean isNotAvailable() {
        return stock <= 0;
    }

    public boolean isNotInStock() {
        return stock <= 0;
    }

    public boolean isNotActive() {
        return !active;
    }
}
