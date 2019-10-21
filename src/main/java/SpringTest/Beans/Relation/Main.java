package SpringTest.Beans.Relation;

import SpringTest.Beans.AutoWire.Address;
import SpringTest.Beans.AutoWire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");

        //继承
        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);

        //依赖
        Person person = (Person) ctx.getBean("person2");
        System.out.println(person);
    }
}
