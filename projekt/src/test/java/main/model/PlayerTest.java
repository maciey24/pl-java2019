package main.model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getPlayersShape() {
        Player player = new Player(Turn.CIRCLE);

        Shape shape = player.getPlayersShape();

        assertEquals(shape.getClass(), Circle.class);
    }
    @Test
    void getPlayersShape2() {
        Player player = new Player(Turn.RECTANGLE);

        Shape shape = player.getPlayersShape();

        assertEquals(shape.getClass(), Rectangle.class);
    }

    @Test
    void getPlayersShape3() {
        Player player = new Player();

        Shape shape = player.getPlayersShape();

        assertEquals(shape.getClass(), Circle.class);
    }

    @Test
    void getOpponentShape() {
        Player player = new Player(Turn.CIRCLE);

        Shape shape = player.getOpponentShape();

        assertEquals(shape.getClass(), Rectangle.class);
    }
    @Test
    void getOpponentShape2() {
        Player player = new Player(Turn.RECTANGLE);

        Shape shape = player.getOpponentShape();

        assertEquals(shape.getClass(), Circle.class);
    }

    @Test
    void checkIfCanPutElement() {
        Player player = new Player();

        Assertions.assertThrows(CannotPutElementException.class, () ->
                player.checkIfCanPutElement(null));
    }

    @Test
    void checkIfCanPutElement2() {
        Player player = new Player();

        Assertions.assertThrows(CannotPutElementException.class, () ->
                player.checkIfCanPutElement(Turn.RECTANGLE));
    }

    @Test
    void checkIfCanPutElement3() {
        Player player = new Player();

        Assertions.assertDoesNotThrow(() ->
                player.checkIfCanPutElement(Turn.CIRCLE));
    }
}