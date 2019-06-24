package main.model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
public class Player {
    private Turn playerSign;

    public Player() {
        playerSign = Turn.CIRCLE;
    }

    public Player(Turn playerSign) {
        this.playerSign = playerSign;
    }

    public <T extends Shape> T getPlayersShape() {
        if (playerSign.equals(Turn.CIRCLE))
            return (T) new Circle();
        else return (T) new Rectangle();
    }

    //nie wiem czy lepiej jest tak jak wyzej czy jak nizej
    public Shape getOpponentShape() {
        if (playerSign.equals(Turn.CIRCLE))
            return new Rectangle();
        else return new Circle();
    }

    //for offline debug
    public <T extends Shape> T getPlayersShape(Turn turn) {
        if (turn.equals(Turn.CIRCLE))
            return (T) new Circle();
        else return (T) new Rectangle();
    }

    public void checkIfCanPutElement(Turn turn) throws CannotPutElementException {
        if (turn == null) throw new CannotPutElementException("the game is over already");
        if (!turn.equals(playerSign)) throw new CannotPutElementException("it's not your turn!");
    }

}
