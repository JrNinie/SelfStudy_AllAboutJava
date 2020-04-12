import com.kuang.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void testBeforeAfterLog(){

        ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理，代理的是接口，如果这里在UserService.class改成UserServiceImpl.class就报错
        UserService userService = context.getBean("userService", UserService.class);
        userService.delete();
        //com.kuang.service.UserServiceImpl的delete方法被执行了
        //删除了用户
        //执行了delete方法，返回值是：null
    }
}
