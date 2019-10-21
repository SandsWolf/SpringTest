package SpringTest.Beans.Annotation.Service;

import SpringTest.Beans.Annotation.Controller.UserController;
import SpringTest.Beans.Annotation.Repository.UserRepositoryImp;
import SpringTest.Beans.Annotation.TestObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

        TestObject testObject = (TestObject) ctx.getBean("testObject");
        System.out.println(testObject);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();

        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService);

        UserRepositoryImp userRepositoryImp = (UserRepositoryImp) ctx.getBean("userRepository");
        System.out.println(userRepositoryImp);



    }
}