import com.kuang.pojo.User;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //user的别名是goodUser所以用其中任何一个名字都是可以的
        //User user= (User) context.getBean("user");
        User user= (User) context.getBean("goodUser");
        user.showName();
    }
}
