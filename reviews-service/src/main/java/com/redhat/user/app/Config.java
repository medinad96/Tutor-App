package com.redhat.user.app;

import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.spring.provider.SpringRemoteCacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@EnableCaching
public class Config {

    @Bean
    public SpringRemoteCacheManager cacheManager() throws Exception {
        Configuration config = new ConfigurationBuilder()
                .addServer()
                .host("datagrid-hotrod")
                .port(11333)
                .build();

        return new SpringRemoteCacheManager(new RemoteCacheManager(config));
    }

}

