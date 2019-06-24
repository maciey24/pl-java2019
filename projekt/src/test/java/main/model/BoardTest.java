package main.model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import main.controller.Window;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class BoardTest {

    @Mock
    Window window;

    @BeforeAll
    static public void init() {

    }

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        doNothing().when(window).update(anyInt(), anyInt(), any(Shape.class));
    }

    @Test
    void getElementAfterInit() {
        Board board = new Board(null);

        Shape shape = board.getElement(0, 0);

        Assertions.assertNull(shape);
    }

    @Test
    void getElementAfterInit2() {
        Board board = new Board(null);

        Shape shape = board.getElement(2, 1);

        Assertions.assertNull(shape);
    }

    @Test
    void setElement() {
        Board board = new Board(window);
        GridIndex gridIndex = new GridIndex(1, 1);

        board.setElement(gridIndex, new Circle());

        assertNotNull(board.getElement(1, 1));
        assertNull(board.getElement(0, 0));
        assertNull(board.getElement(0, 1));
        assertNull(board.getElement(0, 2));
        assertNull(board.getElement(1, 0));
        assertNull(board.getElement(1, 2));
        assertNull(board.getElement(2, 0));
        assertNull(board.getElement(2, 1));
        assertNull(board.getElement(2, 2));
    }

    @Test
    void checkIfOccupied() throws CannotPutElementException {
        Board board = new Board(window);
        GridIndex gridIndex = new GridIndex(1, 1);

        board.setElement(gridIndex, new Circle());

        Assertions.assertThrows(CannotPutElementException.class, () ->
                board.checkIfOccupied(gridIndex));
    }

    @Test
    void checkIfNotOccupied() throws CannotPutElementException {
        Board board = new Board(window);
        GridIndex gridIndex = new GridIndex(1, 1);
        GridIndex gridIndexOther = new GridIndex(2, 1);

        board.setElement(gridIndex, new Circle());

        Assertions.assertDoesNotThrow(() ->
                board.checkIfOccupied(gridIndexOther));
    }

}