import com.kuang.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest {
    public static void main(String[] args) {
        //获取context上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");

        //getBean返回的是objet需要cast
        Hello hello = (Hello) context.getBean("h4");
        System.out.println(hello.getGreeting());

    }
}
