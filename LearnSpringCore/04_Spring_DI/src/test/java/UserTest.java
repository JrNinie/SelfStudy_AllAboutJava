import com.kuang.service.pojo.User;
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

    //prototype且当类中没有重写equals方法时
    @Test
    public void testPrototypeWithoutOverrideEquals(){
        User user1 = context.getBean("userP",User.class);
        User user2 = context.getBean("userP",User.class);
        System.out.println(user1.hashCode());//480971771
        System.out.println(user2.hashCode());//1586845078
        System.out.println(user1 == user2); //false,比较的是堆内存地址(new了两次，开辟了两次内存空间)
        System.out.println(user1.equals(user2)); //false,比较的是hashcode,因为User类里并没有重写equals，所以就相当于是==
    }

      //prototype且当类中重写了equals和hashcode方法时
    @Test
    public void testPrototypeWithOverrideEquals(){
        User user1 = context.getBean("userP",User.class);
        User user2 = context.getBean("userP",User.class);
        System.out.println(user1.hashCode()); //1965882958
        System.out.println(user2.hashCode()); //1965882958
        System.out.println(user1 == user2); //false,比较的是堆内存地址(new了两次，开辟了两次内存空间)
        System.out.println(user1.equals(user2)); //true,比较的是hashcode,因为重写了equals和hashcode方法，因此比较的是值，而不再是默认的内存地址
    }

}
