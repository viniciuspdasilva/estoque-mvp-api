package br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.entities;

import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "price", nullable = false, precision = 10,scale = 2)
    BigDecimal price = BigDecimal.ZERO;

    @Column(name = "description", length = 255)
    String description;

    @Column(name = "category")
    String category;

    @Column(name = "image")
    String image;

    @Column(name = "stock")
    Integer stock;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    boolean active = true;

    public static ProductEntity fromDomain(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.id());
        entity.setTitle(product.title());
        entity.setPrice(product.price());
        entity.setDescription(product.description());
        entity.setCategory(product.category());
        entity.setImage(product.image());
        entity.setStock(product.stock());
        entity.setActive(product.active());
        return entity;
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getTitle(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getImage(),
                entity.getStock(),
                entity.isActive()
        );
    }
}
