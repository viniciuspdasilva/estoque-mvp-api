package br.com.pucrs.estoque_mvp_api.application.port.output.jdbc;

import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;

public interface ChangeExistingProductJDBCOutputPort {
    void change(Product product);
}
