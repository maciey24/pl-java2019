package main.model;

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
        Board board = new Board();
    }
}