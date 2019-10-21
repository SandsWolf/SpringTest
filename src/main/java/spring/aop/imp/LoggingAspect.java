package spring.aop.imp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;



//把类声明为切面：首先加@Component注解，把类放入IOC容器中，在用@Aspect注解声明为一个切面
@Component
@Aspect
public class LoggingAspect {

    //前置通知
    @Before("execution(public int spring.aop.imp.ArithmeticCalculatorImp.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins" + args);
    }

    //后置通知，在目标方法执行后执行，无论是否发生异常
    @After("execution(* spring.aop.imp.ArithmeticCalculator.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    //返回通知
    /*
    在方法正常结束后执行的代码
    返回通知可以访问到返回值
     */
    @AfterReturning(value = "execution(* spring.aop.imp.ArithmeticCalculator.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends " + result);
    }

    /*
    异常通知

     */
    @AfterThrowing(value = "execution(* spring.aop.imp.ArithmeticCalculator.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends " + ex );
    }

}
