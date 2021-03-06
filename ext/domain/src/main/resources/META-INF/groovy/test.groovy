import com.xiaomi.example.domain.dal.repository.UserRepository
import com.xiaomi.example.domain.pojo.User
import com.xiaomi.example.domain.service.FileOpera
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

import javax.annotation.Resource

public class DefaultFileOperate implements FileOpera{

    @Resource
    private UserRepository userRepository;

    User operate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/applicationContext.xml");
        userRepository = ac.getBean("userRepository");
        User user = userRepository.loadByUserId(47);
        return user;
    }
}