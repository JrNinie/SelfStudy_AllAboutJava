import com.kuang.service.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
没有spring之前的方法:
业务层service和数据层dao是各司其职的
 */
public class OldTest {

    public static void main(String[] args) {

        /*v1:
        (对应UserServiceImpl里面的V1)
         */
//        UserService userService = new UserServiceImpl();
//        userService.getUser();

        /*v2:
        (对应UserServiceImpl里面的V2)
         */
//        UserService userService = new UserServiceImpl();
//        //这里可以被动地去接收动态的值
//        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();


        /*v3:
        利用IOC原理，使用bean.xml配置文件
         */
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml");
        UserService  userService = (UserService) context.getBean("userServiceImpl");
        userService.getUser();
    }
}
