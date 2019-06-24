package main.model;

import javafx.scene.shape.Shape;

public class TicTacToeRule {
    public Shape checkWhoWon(Board board) {
        Shape result = null;
        Shape[][] array = board.array;
        for (int i = 0; i < array.length; i++) {
            result = check(array[i]);
            if (result != null) return result;
        }
        for (int i = 0; i < array.length; i++) {
            result = check(array, i);
            if (result != null) return result;
        }
        result = checkDiagonal(array);
        if (result != null) return result;
        return null;
    }

    //check row
    private Shape check(Shape[] array) {
        Shape result = array[0];
        if (result == null) return null;
        for (int i = 0; i < array.length; i++) {
            if (areDifferentShape(array[i], result)) return null;
        }
        return result;
    }

    //check i column in 2d array
    private Shape check(Shape[][] array, int i) {
        Shape result = array[0][i];
        if (result == null) return null;
        for (int j = 0; j < array.length; j++) {
            if (areDifferentShape(array[j][i], result)) return null;
        }
        return result;
    }

    private Shape checkDiagonal(Shape[][] array) {
        Shape result = checkDiagonal1(array);
        if (result != null) return result;
        result = checkDiagonal2(array);
        if (result != null) return result;
        return null;
    }

    private Shape checkDiagonal1(Shape[][] array) {
        Shape result = array[0][0];
        if (result == null) return null;
        for (int i = 0; i < array.length; i++) {
            if (areDifferentShape(array[i][i], result)) return null;
        }
        return result;
    }

    private Shape checkDiagonal2(Shape[][] array) {
        Shape result = array[0][array.length - 1];
        if (result == null) return null;
        for (int i = 0; i < array.length; i++) {
            if (areDifferentShape(array[i][array.length - 1 - i], result))
                return null;
        }
        return result;
    }


    private boolean areDifferentShape(Shape s1, Shape s2) {
        if (s1 == null || s2 == null) return true;
        else return !s1.getClass().equals(s2.getClass());
    }

}
