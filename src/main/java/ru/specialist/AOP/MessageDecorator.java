package ru.specialist.AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MessageDecorator implements MethodInterceptor {
    /*
    @Override
    public void before(Method method, Object [] args, Object target){
       System.out.printf(" INFO: execute method %s , for object %s\n",
               method.getName(), target);
    }


     */

   @Override
    public Object invoke(MethodInvocation invoke)throws Throwable{
       System.out.printf("Info: execute method '%s', for object %s\n ",
               invoke.getMethod().getName(), invoke.getThis());
       System.out.print(" Слова внутри метода :  ");
       Object retVal = invoke.proceed();
       System.out.printf(" Successfully executed method '%s' , for object %s, with return: %s\n",
               invoke.getMethod().getName(), invoke.getThis(), retVal);
       return null;
   }
}
