package br.com.pucrs.estoque_mvp_api.infra.configuration;

import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.ChangeExistingProductJDBCOutputPort;
import br.com.pucrs.estoque_mvp_api.application.port.output.jdbc.FindProductByIdOutputPort;
import br.com.pucrs.estoque_mvp_api.application.usecase.ChangeExistingProductJDBCUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ChangeExistingProductJDBCUseCaseConfiguration {
    private final ChangeExistingProductJDBCOutputPort changeExistingProductJDBCOutputPort;
    private final FindProductByIdOutputPort findProductJDBCOutputPort;

    public ChangeExistingProductJDBCUseCaseConfiguration(
            ChangeExistingProductJDBCOutputPort changeExistingProductJDBCOutputPort,
            FindProductByIdOutputPort findProductJDBCOutputPort
    ) {
        this.changeExistingProductJDBCOutputPort = changeExistingProductJDBCOutputPort;
        this.findProductJDBCOutputPort = findProductJDBCOutputPort;
    }

    @Bean
    public ChangeExistingProductJDBCUseCase createChangeExistingProductJDBCUseCase() {
        return new ChangeExistingProductJDBCUseCase(
                changeExistingProductJDBCOutputPort,
                findProductJDBCOutputPort
        );
    }
}
