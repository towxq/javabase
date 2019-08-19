package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CompanyConfig {

    @Bean
    @Scope("singleton")
    public Employee employee(){
        return new Employee();
    }
}
