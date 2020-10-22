package com.learning.springboot.configs;

import com.learning.springboot.notification.Notifier;
import com.learning.springboot.notification.NotifierEmail;
import com.learning.springboot.service.ServiceActivationClientWithoutObserver;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ConfigLearning {

    @Bean
    public Notifier notifierEmail(){
        NotifierEmail notifier = new NotifierEmail("smtp.packtudo.com");
        notifier.setUpperCase(true);
        return notifier;
    }

    @Bean
    public ServiceActivationClientWithoutObserver serviceActivationClientWithoutObserver(){
        return new ServiceActivationClientWithoutObserver();
    }

}
