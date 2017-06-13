package com.desmond.spring.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvLoader {

    private static final Logger LOG = LoggerFactory.getLogger(EnvLoader.class);

    private static Env env;

    private Properties properties;

    private synchronized void loadEnvFile() {
        Map<String, String> map = new HashMap<>();
        LOG.info("begin to read resource properties file: {}", properties);
        for (String prop : properties.stringPropertyNames()) {
            LOG.debug("read property {}: {}", prop, properties.getProperty(prop));
            map.put(prop, properties.getProperty(prop));
        }

        this.env = new Env(map);
    }

    public void setProperties(Properties properties){
        this.properties = properties;
    }
    public Env getEnv() {
        if (this.env == null) {
            this.loadEnvFile();
        }

        return this.env;
    }

    public static String get(String key){
        return env.get(key);
    }
}