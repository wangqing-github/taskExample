package com.example.task.example.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.Environment;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Map;

public class SpringContext {

    private static final Object syncObj = new Object();
    private static SpringContext _inst;

    public static SpringContext inst() {
        if (_inst == null) {
            synchronized (syncObj) {
                if (_inst == null)
                    _inst = new SpringContext();
            }
        }
        return _inst;
    }

    private static ApplicationContext applicationContext;
    private String host;

    private SpringContext() {
        try {
            host = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public <T> T getBean(Class<T> clazz) {
        if (clazz == null) throw new RuntimeException("class cannot be null");
        return applicationContext.getBean(clazz);
    }

    public <T> T getBean(Class<T> clazz,String name) {
        if (!applicationContext.containsBean(name)) return null;
        return applicationContext.getBean(name,clazz);
    }

    public <T> Map<String,T> getInterfaceBeans(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }

    public Environment getEnvironment() {
        return applicationContext.getEnvironment();
    }

    public String getProperty(String key) {
        return applicationContext.getEnvironment().getProperty(key);
    }

    public void publishEvent(ApplicationEvent event){
        applicationContext.publishEvent(event);
    }

}
