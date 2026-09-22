package br.com.pucrs.estoque_mvp_api.adapter.output;

import br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.entities.ProductEntity;
import br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.repository.ProductRepository;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.FindProductByIdOutputPort;
import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindProductByIdAdapter implements FindProductByIdOutputPort {

    private final ProductRepository repository;

    public FindProductByIdAdapter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product findProductById(Integer id) {
        Optional<ProductEntity> byId = repository.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Product not found");
        }
        return ProductEntity.toDomain(byId.get());
    }
}
