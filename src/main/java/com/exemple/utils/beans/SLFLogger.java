package com.exemple.utils.beans;


import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,METHOD,FIELD})
@Retention(RUNTIME)
@Qualifier
public @interface SLFLogger {
}
