package com.exemple.utils.beans.interceptors;


import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Loggeble
@Interceptor
@Priority(Interceptor.Priority.APPLICATION+100)
public class LoggingInterceptor {




    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        System.out.println("ENTRING ------------"+ic.getMethod().getName().toUpperCase()+"------------");
        try {
            return ic.proceed();
        }finally {
            System.out.println("EXITING ------------"+ic.getMethod().getName().toUpperCase()+"------------");
        }
    }
}
