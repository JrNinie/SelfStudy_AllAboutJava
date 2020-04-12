import com.kuang.service.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {



    @Test
    public void testAutowired(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);
        person.getCat().eat();
        person.getDog().eat();

    }


    @Test
    public void testWithAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("anno_beans.xml");
        Person person = context.getBean("person", Person.class);
        person.getCat().eat();
        person.getDog().eat();

    }
}
