package ru.specialist.AOP;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.MessageSource;

public class App {

    public static void main(String [] args){
        MessageWriter target = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);
        MessageWriter proxy = (MessageWriter) pf.getProxy();
        proxy.writeMessage();
        proxy.printMessage();


    /*
       Pointcut pc = new SimpleStaticPointcut();
       Advice advice = new MessageDecorator();
       Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
       ProxyFactory pf = new ProxyFactory();
       pf.addAdvisor(advisor);
       pf.setTarget(target);
       MessageWriter proxy = (MessageWriter)pf.getProxy();
       proxy.writeMessage();
       proxy.printMessage();


     */
    }
}
