package com.inho.ward.account.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartUpEnvironment implements ApplicationListener<ApplicationStartedEvent> {
    private final Environment env;
    @Autowired
    public ApplicationStartUpEnvironment(Environment env) {
        this.env = env;
    }
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        final String RIOT_API_KEY = env.getProperty("RIOT_API_KEY");
    }
}
