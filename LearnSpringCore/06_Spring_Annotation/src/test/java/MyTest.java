import com.kuang.service.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


    @Test
    public void testComponent(){
        User user = context.getBean("user", User.class);
        System.out.println(user.getFirstName());
    }

}
