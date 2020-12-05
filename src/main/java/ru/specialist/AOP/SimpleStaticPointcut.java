package ru.specialist.AOP;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches (Method method, Class<?> targetClass){
        return (method.getName().contains("write")|| method.getName().contains("print"));
    }
}
