package solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import solution.domain.CompanyReport;

@Configuration
public class CompanyConfig {
    @Bean
    public CompanyReport companyReport() {
        return new CompanyReport();
    }
}
