package com.connectfour;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.connectfour.service.UserService;

public class ConnectFour {
    public static void main(String []arg){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = (UserService)context.getBean("userService");
        short s = 0;
        userService.addUser(0, "phil", "password", s, "grey", "red", "yellow");
        context.close();
    }
}
