package main.model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import main.controller.Window;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;

class TicTacToeRuleTest {

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
    void checkWhoWon() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertNull(whoWon);
    }

    @Test
    void checkWhoWon2() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();
        GridIndex gridIndex = new GridIndex(0, 0);
        board.setElement(gridIndex, new Circle());

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertNull(whoWon);
    }

    @Test
    void checkWhoWon3() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();
        GridIndex gridIndex = new GridIndex(0, 0);
        board.setElement(gridIndex, new Circle());
        gridIndex = new GridIndex(1, 0);
        board.setElement(gridIndex, new Circle());
        gridIndex = new GridIndex(2, 0);
        board.setElement(gridIndex, new Circle());

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertEquals(whoWon.getClass(), Circle.class);
    }

    @Test
    void checkWhoWon4() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();
        GridIndex gridIndex = new GridIndex(0, 0);
        board.setElement(gridIndex, new Rectangle());
        gridIndex = new GridIndex(1, 1);
        board.setElement(gridIndex, new Rectangle());
        gridIndex = new GridIndex(2, 2);
        board.setElement(gridIndex, new Rectangle());

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertEquals(whoWon.getClass(), Rectangle.class);
    }

    @Test
    void checkWhoWon5() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();
        GridIndex gridIndex = new GridIndex(0, 2);
        board.setElement(gridIndex, new Rectangle());
        gridIndex = new GridIndex(1, 1);
        board.setElement(gridIndex, new Rectangle());
        gridIndex = new GridIndex(2, 0);
        board.setElement(gridIndex, new Rectangle());

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertEquals(whoWon.getClass(), Rectangle.class);
    }
    @Test
    void checkWhoWon6() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();
        GridIndex gridIndex = new GridIndex(0, 2);
        board.setElement(gridIndex, new Rectangle());
        gridIndex = new GridIndex(1, 1);
        board.setElement(gridIndex, new Rectangle());
        gridIndex = new GridIndex(2, 0);
        board.setElement(gridIndex, new Rectangle());
        gridIndex = new GridIndex(1, 0);
        board.setElement(gridIndex, new Circle());

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertEquals(whoWon.getClass(), Rectangle.class);
    }
    @Test
    void checkWhoWon7() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();
        GridIndex gridIndex = new GridIndex(0, 0);
        board.setElement(gridIndex, new Circle());
        gridIndex = new GridIndex(0, 1);
        board.setElement(gridIndex, new Circle());
        gridIndex = new GridIndex(0, 2);
        board.setElement(gridIndex, new Circle());

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertEquals(whoWon.getClass(), Circle.class);
    }
    @Test
    void checkWhoWon8() {
        Board board = new Board(window);
        TicTacToeRule ticTacToeRule = new TicTacToeRule();
        GridIndex gridIndex = new GridIndex(0, 0);
        board.setElement(gridIndex, new Circle());
//        gridIndex = new GridIndex(0, 1);
//        board.setElement(gridIndex, new Circle());
        gridIndex = new GridIndex(0, 2);
        board.setElement(gridIndex, new Circle());

        Shape whoWon = ticTacToeRule.checkWhoWon(board);

        assertNull(whoWon);
    }
}