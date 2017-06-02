package com.desmond.spring.env;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class EnvFactoryBean implements FactoryBean<Env> {

    @Autowired
    private EnvLoader envLoader;

    private Env cacheEnv;

    @Override
    public Env getObject() throws Exception {
        if (cacheEnv == null) {
            this.reload();
        }

        return cacheEnv;
    }

    @Override
    public Class<?> getObjectType() {
        return Env.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public synchronized void reload() {
        this.cacheEnv = this.envLoader.getEnv();
    }
}
