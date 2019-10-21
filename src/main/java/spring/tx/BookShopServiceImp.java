package spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service("bookShopService")
public class BookShopServiceImp implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;

    @Transactional
    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        bookShopDao.updateBookStock(isbn);

        bookShopDao.updateUserAccount(username,price);

    }
}
