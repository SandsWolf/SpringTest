package SpringTest.Beans.Properties;


import SpringTest.Beans.Collocation.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");

        javax.sql.DataSource dataSource = (javax.sql.DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
