package br.com.pucrs.estoque_mvp_api.application.port.input.rest;

import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;

public interface InsertProductInputPort {
    void execute(Product product);
}
