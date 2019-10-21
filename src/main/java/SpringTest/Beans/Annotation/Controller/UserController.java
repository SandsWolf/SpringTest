package SpringTest.Beans.Annotation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserController userController;
    public void execute(){
        System.out.println("UserController Execute...");
    }
}
