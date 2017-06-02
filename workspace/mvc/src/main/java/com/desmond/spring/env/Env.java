package com.desmond.spring.env;

import java.util.Map;

public class Env {

    private Map<String, String> properties;

    public Env(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String get(String key) {
        return this.properties.get(key);
    }
}
