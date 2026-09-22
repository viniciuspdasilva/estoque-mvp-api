package br.com.pucrs.estoque_mvp_api.adapter.output;

import br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.entities.ProductEntity;
import br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.repository.ProductRepository;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.InsertProductJDBCOutputPort;
import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import org.springframework.stereotype.Service;

@Service
public class InsertProductJDBCAdapter implements InsertProductJDBCOutputPort {

    private final ProductRepository productRepository;

    public InsertProductJDBCAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void insert(Product product) {
        productRepository.save(ProductEntity.fromDomain(product));
    }
}
