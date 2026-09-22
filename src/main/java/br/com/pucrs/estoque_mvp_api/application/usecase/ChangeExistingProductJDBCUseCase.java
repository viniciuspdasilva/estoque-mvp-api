package br.com.pucrs.estoque_mvp_api.application.usecase;

import br.com.pucrs.estoque_mvp_api.application.port.input.rest.ChangeExistingProductInputPort;
import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.ChangeExistingProductJDBCOutputPort;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.FindProductByIdOutputPort;

public class ChangeExistingProductJDBCUseCase implements ChangeExistingProductInputPort {

    private final ChangeExistingProductJDBCOutputPort changeExistingProductJDBCOutputPort;
    private final FindProductByIdOutputPort findProductJDBCOutputPort;

    public ChangeExistingProductJDBCUseCase(
            ChangeExistingProductJDBCOutputPort changeExistingProductJDBCOutputPort,
            FindProductByIdOutputPort findProductJDBCOutputPort
    ) {
        this.changeExistingProductJDBCOutputPort = changeExistingProductJDBCOutputPort;
        this.findProductJDBCOutputPort = findProductJDBCOutputPort;
    }

    @Override
    public void change(Integer id, Product product) throws IllegalAccessException {
        Product productFound = findProductJDBCOutputPort.findProductById(id);
        if (productFound == null){
            throw new IllegalAccessException("Product not found");
        }
        changeExistingProductJDBCOutputPort.change(productFound);
    }
}
