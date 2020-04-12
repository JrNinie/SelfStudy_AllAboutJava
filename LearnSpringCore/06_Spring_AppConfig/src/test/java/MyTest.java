import com.kuang.service.config.MyConfig;
import com.kuang.service.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    //获取通过MyConfig类设置的context
     ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
     @Test
     public void testUser(){
         User user = context.getBean("user", User.class);
         System.out.println(user.getName());
     }

}
