import com.ttn.Spring_jdbc.Spring_jdbc;
import com.ttn.databaseConnection.CustomJDBCTemplate;
import com.ttn.databaseConnection.NamedParameterDemo;
import com.ttn.databaseConnection.User;
import com.ttn.databaseConnection.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        Spring_jdbc spring_jdbc = (Spring_jdbc) applicationContext.getBean("mybean");
        spring_jdbc.preparedStatement();
        CustomJDBCTemplate customjdbcTemplate = (CustomJDBCTemplate) applicationContext.getBean("customjbdcTemplate");
//        customjdbcTemplate.userCount();
//        customjdbcTemplate.getUserName();

//        User user = (User) applicationContext.getBean("user");
//        customjdbcTemplate.insertUser(user);

//        customjdbcTemplate.queryForMapDemo();

//        customjdbcTemplate.queryForListDemo();

//         customjdbcTemplate.getUser();

        NamedParameterDemo namedParameterDemo = (NamedParameterDemo) applicationContext.getBean("namedParameterDemo");
        User user1 =  namedParameterDemo.namedParameterJdbcTemplateDemo();
        System.out.println(user1);
    }
}

