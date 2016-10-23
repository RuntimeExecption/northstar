import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/10/23.
 */


@RestController
@EnableAutoConfiguration

public class MainController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/test/login")
    @ResponseBody
    String login(String username,String password) {
        return "success,userName="+username+",password="+password;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }
}
