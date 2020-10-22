package com.learning.springboot.configs;

import com.learning.springboot.service.ServiceActivationClientWithoutObserver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigService {

    @Bean
    public ServiceActivationClientWithoutObserver serviceActivationClientWithoutObserver(){
        return new ServiceActivationClientWithoutObserver();
    }

}
