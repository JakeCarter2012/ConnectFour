package com.connectfour.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.connectfour.forms.IdForm;
import com.connectfour.forms.PlayPieceForm;
import com.connectfour.gameData.BoardPiece;
import com.connectfour.service.GameBoardService;
import com.connectfour.service.GameService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.connectfour.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/gameBoard")
public class GameBoardController {
    @Autowired
    private GameBoardService gameBoardService;
    @Autowired
    private GameService gameService;
    @Autowired
    private UserService userService;
    
    //Adds a piece from the player to the board. 
    //First checks to see if the token is inside the board's bounds,
    //then checks to see if it's the player who played the piece's turn.
    //Then, checks to see if the game would finish if the pice is played;
    //if the game is not ended, the piece is add to othe board.
    //Returns 1 if the player won, 0 if the game continues, or -1 for a tie.
    //TO USE: Send a JSON object with GameId, PlayedBy, TokenX, and TokenY
    @RequestMapping(value = "/playPiece", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Integer> playPiece(@RequestBody PlayPieceForm pieceForm)
    {
        if(pieceForm.getTokenX() > 7 || pieceForm.getTokenX() < 1 || 
                pieceForm.getTokenY() > 7 || pieceForm.getTokenY() < 1)
        {
            return ResponseEntity.badRequest().body(-1);
        }
        
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        int gameStatus = 0;
        
        if(gameService.getTurn(pieceForm.getGameId()) == pieceForm.getPlayedBy()){
            gameStatus = gameBoardService.getGameState(pieceForm.getGameId(), pieceForm.getPlayedBy(), pieceForm.getTokenX(), pieceForm.getTokenY());
            if(gameStatus == 0)
            {
                gameBoardService.playPiece(pieceForm.getGameId(), pieceForm.getPlayedBy(), pieceForm.getTokenX(), pieceForm.getTokenY());
            }
            else
            {
                userService.addWin(pieceForm.getPlayedBy());
                gameService.endGame(pieceForm.getGameId());
            }
        }
        
        context.close();
        return ResponseEntity.ok(gameStatus);
    } 
        
    //Returns a list of all the pieces on the board
    //TO USE: Send a JSON object with Id
    @RequestMapping(value = "/getBoard", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<BoardPiece>> getBoard(@RequestBody IdForm idForm)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        List<BoardPiece> games = gameBoardService.getGameBoard(idForm.getId());
        context.close();
        return ResponseEntity.ok(games);
    }
}
