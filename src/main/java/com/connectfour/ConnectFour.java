package com.connectfour;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
/*
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.connectfour.service.UserService;
*/
@SpringBootApplication
@ImportResource("classpath:config.xml")  
public class ConnectFour {
    public static void main(String []args){
        SpringApplication.run(ConnectFour.class, args);
        /*
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        UserService userService = (UserService)context.getBean("userService");
        short s = 0;
        userService.addUser(0, "billNYEt", "password", s, "grey", "red", "yellow");
        context.close();
*/
    }
}
