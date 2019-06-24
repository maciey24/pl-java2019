package main.model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
public class Player {
    final private Turn playerSign;

    public Player() {
        playerSign = Turn.CIRCLE;
    }

    public <T extends Shape> T getPlayersShape() {
        if (playerSign.equals(Turn.CIRCLE)) return (T) new Circle();
        else return (T) new Rectangle();
    }

    public void checkIfCanPutElement(Turn turn) throws CannotPutElementException {
//        if(!turn.equals(playerSign)) throw new CannotPutElementException("it's not your turn!");
    }
}
