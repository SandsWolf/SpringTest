package SpringTest.Beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
        这两步可以由Spring来完成
        //1.创建对象
        HelloWold helloWold = new HelloWold();
        //2.给对象赋值
        helloWold.setName("MQ");
         */

        //Spring做法
        //1.创建Spring的ICO容器对象
        //ApplicationContext代表IOC容器
        //ClassPathXmlApplicationContext 是ApplicationContext 接口的实现类。该实现类从路径下来加载配置文件。
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        //2.从ICO容器中获取Bean实例
        HelloWold helloWold = (HelloWold) ctx.getBean("hello");
        //调用方法
        helloWold.hello();

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Person person1 = (Person) ctx.getBean("person1");
        System.out.println(person1);

    }
}

