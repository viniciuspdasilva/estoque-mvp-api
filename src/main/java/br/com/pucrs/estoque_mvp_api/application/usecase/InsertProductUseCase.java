package br.com.pucrs.estoque_mvp_api.application.usecase;

import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import br.com.pucrs.estoque_mvp_api.application.port.input.rest.InsertProductInputPort;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.InsertProductJDBCOutputPort;

public class InsertProductUseCase implements InsertProductInputPort {

    private final InsertProductJDBCOutputPort insertProductOutputPort;

    public InsertProductUseCase(InsertProductJDBCOutputPort insertProductOutputPort) {
        this.insertProductOutputPort = insertProductOutputPort;
    }

    @Override
    public void execute(Product product) {
        insertProductOutputPort.insert(product);
    }
}
