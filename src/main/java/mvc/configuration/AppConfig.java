package mvc.configuration;

import mvc.repository.ObjRepository;
import mvc.service.ObjService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ObjService objService(){
        return new ObjService();
    }
}
