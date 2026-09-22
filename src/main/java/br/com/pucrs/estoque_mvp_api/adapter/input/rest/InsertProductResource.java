package br.com.pucrs.estoque_mvp_api.adapter.input.rest;

import br.com.pucrs.estoque_mvp_api.application.domain.model.Product;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.InsertProductJDBCOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController("/products")
public class InsertProductResource {

    private final InsertProductJDBCOutputPort insertProductJDBCOutputPort;

    public InsertProductResource(InsertProductJDBCOutputPort insertProductJDBCOutputPort) {
        this.insertProductJDBCOutputPort = insertProductJDBCOutputPort;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        insertProductJDBCOutputPort.insert(product);
        return ResponseEntity.created(URI.create("/products")).build();
    }
}
