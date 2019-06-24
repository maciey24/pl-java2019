package main.model;

import javafx.scene.shape.Shape;
import main.controller.Window;

public class Board {
    Shape[][] array;
    private Window window;

    Board(Window window) {
        this.array = new Shape[3][3];
        //observer pattern - set observer
        this.window = window;
    }

    private  <T extends Shape> void setElement(int i, int j, T element) {
        this.array[i][j] = element;
        //observer notify
        window.update(i, j, element);
    }

    public Shape getElement(int i, int j) {
        return this.array[i][j];
    }

    public void checkIfOccupied(GridIndex gridIndex) throws CannotPutElementException {
        if (this.getElement(gridIndex.getI(), gridIndex.getJ()) != null)
            throw new CannotPutElementException("place is already taken");
    }

    public  <T extends Shape> void setElement(GridIndex gridIndex, T toChange) throws CannotPutElementException {
        this.setElement(gridIndex.getI(), gridIndex.getJ(), toChange);
    }
}
