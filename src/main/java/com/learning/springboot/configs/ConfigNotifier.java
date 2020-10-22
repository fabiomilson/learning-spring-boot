package com.learning.springboot.configs;

import com.learning.springboot.UrgencyLevel;
import com.learning.springboot.notification.Notifier;
import com.learning.springboot.notification.NotifierEmail;
import com.learning.springboot.notification.NotifierSMS;
import com.learning.springboot.notification.mock.MockNotifierEmail;
import com.learning.springboot.service.annotations.TypeNotifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigNotifier {

    @Bean
    @TypeNotifier(UrgencyLevel.NORMAL)
    @Profile("prod")
    public Notifier notifierEmail(){
        NotifierEmail notifier = new NotifierEmail("smtp.packtudo.com");
        notifier.setUpperCase(true);
        return notifier;
    }

    @Bean
    @TypeNotifier(UrgencyLevel.NORMAL)
    @Profile("dev")
    public Notifier mockNotifierEmail(){
        MockNotifierEmail notifier = new MockNotifierEmail("smtp.packtudo.com");
        notifier.setUpperCase(true);
        return notifier;
    }

    @Bean
    @TypeNotifier(UrgencyLevel.URGENCY)
    //@Primary
    public Notifier notifierSMS(){
        return new NotifierSMS();
    }


}
