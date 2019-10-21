package SpringTest.Beans.Annotation.Service;

import SpringTest.Beans.Annotation.Controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserController userController;
    public void add(){
        System.out.println("UserService Add...");
    }
}
