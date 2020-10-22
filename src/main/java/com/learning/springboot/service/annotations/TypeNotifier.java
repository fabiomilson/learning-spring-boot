package com.learning.springboot.service.annotations;

import com.learning.springboot.UrgencyLevel;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier()
public @interface TypeNotifier {

    UrgencyLevel value();
}
