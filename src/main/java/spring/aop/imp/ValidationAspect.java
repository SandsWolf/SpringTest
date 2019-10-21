package spring.aop.imp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
@Order 注解用来定义切面优先级顺序，值越小优先级越高
 */
@Component
@Aspect
@Order(1)
public class ValidationAspect {

    /*
    定义一个方法来声明切入点表达式
    使用@PointCut来声明切入点
    下面的例子中 声明后"execution(* spring.aop.imp.ArithmeticCalculator.*(..)))" 就可以用"declareJointPointExpression()"来表示了
     */
    @Pointcut("execution(* spring.aop.imp.ArithmeticCalculator.*(..)))")
    public void declareJointPointExpression() {}


    @Before("declareJointPointExpression()")
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
