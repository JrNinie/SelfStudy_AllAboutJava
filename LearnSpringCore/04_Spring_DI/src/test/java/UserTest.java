import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testUserP(){
        User user = context.getBean("userP", User.class);
        System.out.println(user.toString());
    }

    @Test
    public void testUserC(){
        User user = context.getBean("userC", User.class);
        System.out.println(user.toString());
    }
}
