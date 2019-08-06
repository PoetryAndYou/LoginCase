import org.junit.Test;

/**
 * @author rui
 * @create 2019-08-06 11:51
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        UserDao userDao=new UserDao();
        User user=new User();
        user.setUsername("admin");
        user.setPassword("ada1");
        User admin = userDao.login(user);
        System.out.println(admin);

    }
}
