package api.muestra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "api.muestra.cash.repository")
public class PersistenceJPAConfig {
}
