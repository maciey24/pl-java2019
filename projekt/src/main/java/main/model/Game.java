package main.model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import lombok.Data;
import main.controller.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Data
@Repository
public class Game {
    private Turn turn;
    private Board board;

    @Autowired
    Player player;

    @Autowired
    Window window;

    public Game() {
        this.turn = Turn.CIRCLE;
    }

    @PostConstruct
    void init() {
        this.board = new Board(window);
    }

    private void switchTurn() {
        if (this.getTurn() == Turn.CIRCLE) {
            this.turn = Turn.RECTANGLE;
        } else this.turn = Turn.CIRCLE;
    }

    private <T extends Shape> T getItemForPlayer() {
        return (T) player.getPlayersShape();
    }

    public <T extends Shape> void putItemOnBoard(Coord x, Coord y) {
        try {
            GridIndex gridIndex = window.getGridIndex(x, y);
            player.checkIfCanPutElement(this.turn);
            Shape toPut = getItemForPlayer();
            board.checkIfOccupied(gridIndex);
            board.setElement(gridIndex, toPut);
            switchTurn();
        } catch (CannotPutElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
