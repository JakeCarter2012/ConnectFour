package com.connectfour.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.connectfour.forms.ForfeitForm;
import com.connectfour.forms.NewGameForm;
import com.connectfour.forms.IdForm;
import com.connectfour.gameData.PersonalGame;
import com.connectfour.service.GameService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    
    //Starts a new game with the two given players
    //TO USE: Send a JSON object with PlayerOne and PlayerTwo
    @RequestMapping(value = "/newGame", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Integer> addGame(@RequestBody NewGameForm gameForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        int gameId = gameService.createGame(gameForm.getPlayerOne(), gameForm.getPlayerTwo());
        context.close();
        return ResponseEntity.ok(gameId);
    }
        
    //Gets a list og GameId's and UserNames for all the games the user is currently playing
    //TO USE: Send a JSON object with Id
    @RequestMapping(value = "/gamesList", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<PersonalGame>> addGame(@RequestBody IdForm idForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        List<PersonalGame> games = gameService.getPersonalGames(idForm.getId());
        context.close();
        return ResponseEntity.ok(games);
    }
       
    //Foreits the current game
    //TO USE: Send a JSON object with GameId and UserId
    @RequestMapping(value = "/forfeit", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> addGame(@RequestBody ForfeitForm forfeitForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        boolean accepted = gameService.forfeitGame(forfeitForm.getGameId(), forfeitForm.getUserId());
        context.close();
        return ResponseEntity.ok(accepted);
    }
    
    //Returns the name of the current turn's player
    //TO USE: Send a JSON object with Id
    @RequestMapping(value = "/getTurn", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> getTurn(@RequestBody IdForm idForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        String name = gameService.getTurnName(idForm.getId());
        context.close();
        return ResponseEntity.ok(name);
    }
}
