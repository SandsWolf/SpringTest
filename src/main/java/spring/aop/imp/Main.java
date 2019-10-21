package spring.aop.imp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop.xml");

        ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);

        int result = arithmeticCalculator.add(1, 2);
        int result2 = arithmeticCalculator.div(10, 0);

        System.out.println(result2);



    }
}
