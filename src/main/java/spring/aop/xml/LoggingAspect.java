package spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


//把类声明为切面：首先加@Component注解，把类放入IOC容器中，在用@Aspect注解声明为一个切面

public class LoggingAspect {

    //前置通知
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins" + args);
    }

    //后置通知，在目标方法执行后执行，无论是否发生异常
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    //返回通知
    /*
    在方法正常结束后执行的代码
    返回通知可以访问到返回值
     */

    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends " + result);
    }

    /*
    异常通知

     */
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends " + ex );
    }

}
