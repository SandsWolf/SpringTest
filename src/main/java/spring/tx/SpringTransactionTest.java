package spring.tx;

import SpringTest.Beans.Collocation.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
    private ApplicationContext cxt = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;

    {
        cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = cxt.getBean(BookShopDao.class);
        bookShopService = cxt.getBean(BookShopService.class);
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

    @Test
    public void testBookShopDaoUpdateBookStock() {
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("Tom",100);
    }


    @Test
    public void testBookShopService() {
        bookShopService.purchase("Tom","1001");
    }
}
