package br.com.pucrs.estoque_mvp_api.adapter.input.rest;

import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import br.com.pucrs.estoque_mvp_api.application.port.input.rest.ChangeExistingProductInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products")
public class ChangeExistingProductResource {
    private final ChangeExistingProductInputPort changeExistingProductInputPort;

    public ChangeExistingProductResource(ChangeExistingProductInputPort changeExistingProductInputPort) {
        this.changeExistingProductInputPort = changeExistingProductInputPort;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeExistingProduct(@PathVariable Integer id, @RequestBody Product request)
            throws IllegalAccessException {
        changeExistingProductInputPort.change(id, request);
        return ResponseEntity.noContent().build();
    }
}
