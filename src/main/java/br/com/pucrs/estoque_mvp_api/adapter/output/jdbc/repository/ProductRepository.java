package br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.repository;

import br.com.pucrs.estoque_mvp_api.adapter.output.jdbc.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
