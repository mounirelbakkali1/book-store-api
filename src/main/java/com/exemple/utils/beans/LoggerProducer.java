package com.exemple.utils.beans;


import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerProducer {

    @Produces
    private Logger getLooger(InjectionPoint in){
        return LoggerFactory.getLogger(in.getMember().getDeclaringClass().getName());
    }
}
