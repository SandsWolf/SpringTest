package SpringTest.Beans.Annotation.Repository;

import org.springframework.stereotype.Repository;

@Repository(value = "userRepository")
public class UserRepositoryImp implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserRespository Save....");
    }
}
