package com.sikar.tamilSchoolP.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Configuration
@Component
@Service
@Controller
public class Configurations {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
