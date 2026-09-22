package br.com.pucrs.estoque_mvp_api.infra.configuration;

import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.InsertProductJDBCOutputPort;
import br.com.pucrs.estoque_mvp_api.application.usecase.InsertProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class InsertProductUseCaseConfiguration {
    final
    InsertProductJDBCOutputPort insertProductOutputPort;

    public InsertProductUseCaseConfiguration(InsertProductJDBCOutputPort insertProductOutputPort) {
        this.insertProductOutputPort = insertProductOutputPort;
    }

    @Bean
    public InsertProductUseCase insertProductUseCase() {
        return new InsertProductUseCase(insertProductOutputPort);
    }
}
