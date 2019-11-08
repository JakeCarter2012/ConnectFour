package com.connectfour.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.connectfour.forms.ChangePasswordForm;
import com.connectfour.forms.ColorChangeForm;
import com.connectfour.forms.LoginForm;
import com.connectfour.forms.UserIdentificationForm;
import com.connectfour.forms.UserNameForm;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.connectfour.service.UserService;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = "application/json")
        public ResponseEntity<String> addUser(@RequestBody LoginForm loginForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        userService.addUser(0, loginForm.getUserName(), loginForm.getUserPassword(),
                (short)0, "blue", "red", "yellow");        
        context.close();
        return ResponseEntity.ok("User added succesfully");
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Integer> getUserId(@RequestBody LoginForm loginForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");        
        int id = userService.getUserId(loginForm.getUserName(), loginForm.getUserPassword());        
        context.close();
        return ResponseEntity.ok(id);
    }
    
    @RequestMapping(value = "/preferences", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<HashMap<String, String>> getUserPreferences(@RequestBody UserIdentificationForm idForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        HashMap<String, String> preferences = userService.getUserPreferences(idForm.getUserId(), idForm.getUserName());        
        context.close();
        return ResponseEntity.ok(preferences);
    }
    
    @RequestMapping(value = "/wins", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Integer> getUserWins(@RequestBody UserNameForm nameForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        int wins = userService.getUserWins(nameForm.getUserName());        
        context.close();
        return ResponseEntity.ok(wins);
    }
    
    @RequestMapping(value = "/changeColors", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<String> changeUserColors(@RequestBody ColorChangeForm colorForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        userService.changeColors(colorForm.getUserId(), colorForm.getUserName(),
                colorForm.getBoardColor(), colorForm.getMyColor(), colorForm.getOpponentColor());        
        context.close();
        return ResponseEntity.ok("Successfully changed colors.");
    }
    
    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Boolean> changeUserPassword(@RequestBody ChangePasswordForm passwordForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        boolean success  = userService.changePassword(passwordForm.GetUserId(), 
                passwordForm.getOldPassword(), passwordForm.getNewPassword());        
        context.close();
        return ResponseEntity.ok(success);
    }
    
    @RequestMapping(value = "/addWin", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<String> addWin(@RequestBody UserIdentificationForm idForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        userService.addWin(idForm.getUserId(), idForm.getUserName());        
        context.close();
        return ResponseEntity.ok("Successfully added a win to " + idForm.getUserName());
    }
}
