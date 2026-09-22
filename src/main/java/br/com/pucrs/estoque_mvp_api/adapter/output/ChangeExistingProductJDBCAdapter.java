package br.com.pucrs.estoque_mvp_api.adapter.output;

import br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.entities.ProductEntity;
import br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.repository.ProductRepository;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.ChangeExistingProductJDBCOutputPort;
import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ChangeExistingProductJDBCAdapter implements ChangeExistingProductJDBCOutputPort {

    private final ProductRepository repository;


    public ChangeExistingProductJDBCAdapter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void change(Product product) {
        ProductEntity entity = ProductEntity.fromDomain(product);
        repository.save(entity);
    }
}
