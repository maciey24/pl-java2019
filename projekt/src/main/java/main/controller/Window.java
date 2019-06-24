package main.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import main.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;

@Controller
public class Window {
    public static final double firstColumnCoord1 = 140.0;
    public static final double firstColumnCoord2 = 233.0;
    public static final double secondColumnCoord1 = 237.0;
    public static final double secondColumnCoord2 = 335.0;
    public static final double thirdColumnCoord1 = 339.0;
    public static final double thirdColumnCoord2 = 432.0;
    public static final double firstRowCoord1 = 97.0;
    public static final double firstRowCoord2 = 172.0;
    public static final double secondRowCoord1 = 179.0;
    public static final double secondRowCoord2 = 250.0;
    public static final double thirdRowCoord1 = 258.0;
    public static final double thirdRowCoord2 = 342.0;
    @Autowired
    Game game;

    @FXML
    GridPane gridpane = new GridPane();

    @FXML
    Circle c00, c01, c02,
            c10, c11, c12,
            c20, c21, c22;

    @FXML
    Rectangle r00, r01, r02,
            r10, r11, r12,
            r20, r21, r22;

    ArrayList<Shape> shapes = new ArrayList<>();
    ArrayList<ArrayList<Circle>> circles = new ArrayList<>();
    ArrayList<ArrayList<Rectangle>> rectangles = new ArrayList<>();

    @FXML
    public void initialize() {
        System.out.println("Window init");
        addAll();
        hideAll(shapes);
        gridpane.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            Coord x = new Coord(e.getX());
            Coord y = new Coord(e.getY());
            System.out.println("x: " + x + "y: " + y);
            game.putItemOnBoard(x, y);
        });
    }

    public GridIndex getGridIndex(Coord x, Coord y) throws CannotPutElementException {
        if (x.between(firstColumnCoord1, firstColumnCoord2) && y.between(firstRowCoord1, firstRowCoord2))
            return new GridIndex(0, 0);
        if (x.between(secondColumnCoord1, secondColumnCoord2) && y.between(firstRowCoord1, firstRowCoord2))
            return new GridIndex(0, 1);
        if (x.between(thirdColumnCoord1, thirdColumnCoord2) && y.between(firstRowCoord1, firstRowCoord2))
            return new GridIndex(0, 2);

        if (x.between(firstColumnCoord1, firstColumnCoord2) && y.between(secondRowCoord1, secondRowCoord2))
            return new GridIndex(1, 0);
        if (x.between(secondColumnCoord1, secondColumnCoord2) && y.between(secondRowCoord1, secondRowCoord2))
            return new GridIndex(1, 1);
        if (x.between(thirdColumnCoord1, thirdColumnCoord2) && y.between(secondRowCoord1, secondRowCoord2))
            return new GridIndex(1, 2);

        if (x.between(firstColumnCoord1, firstColumnCoord2) && y.between(thirdRowCoord1, thirdRowCoord2))
            return new GridIndex(2, 0);
        if (x.between(secondColumnCoord1, secondColumnCoord2) && y.between(thirdRowCoord1, thirdRowCoord2))
            return new GridIndex(2, 1);
        if (x.between(thirdColumnCoord1, thirdColumnCoord2) && y.between(thirdRowCoord1, thirdRowCoord2))
            return new GridIndex(2, 2);

        throw new CannotPutElementException("no element to display at these coords");
    }

    private void addAll() {
        //first row
        ArrayList<Circle> circles0 = new ArrayList<>();
        circles0.add(c00);
        circles0.add(c01);
        circles0.add(c02);
        circles.add(circles0);
        //second row
        ArrayList<Circle> circles1 = new ArrayList<>();
        circles1.add(c10);
        circles1.add(c11);
        circles1.add(c12);
        circles.add(circles1);
        //third row
        ArrayList<Circle> circles2 = new ArrayList<>();
        circles2.add(c20);
        circles2.add(c21);
        circles2.add(c22);
        circles.add(circles2);

        //first row
        ArrayList<Rectangle> rectangles0 = new ArrayList<>();
        rectangles0.add(r00);
        rectangles0.add(r01);
        rectangles0.add(r02);
        rectangles.add(rectangles0);
        //second row
        ArrayList<Rectangle> rectangles1 = new ArrayList<>();
        rectangles1.add(r10);
        rectangles1.add(r11);
        rectangles1.add(r12);
        rectangles.add(rectangles1);
        //second row
        ArrayList<Rectangle> rectangles2 = new ArrayList<>();
        rectangles2.add(r20);
        rectangles2.add(r21);
        rectangles2.add(r22);
        rectangles.add(rectangles2);

        addAll(circles);
        addAll(rectangles);
    }

    //generic functions
    private <T extends Shape> void addAll(ArrayList<ArrayList<T>> listOfLists) {
        for (ArrayList<T> list : listOfLists) {
            shapes.addAll(list);
        }
    }

    private void hideAll(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            shape.setVisible(false);
        }
    }

    //nie wiem dlaczego polimorfizm tak nie dziala, ale chcialem zaimplementowac
    //wzorzec strategii
    public void update(int i, int j, Circle element) {
        this.circles.get(i).get(j).setVisible(true);
    }

    public void update(int i, int j, Rectangle element) {
        this.rectangles.get(i).get(j).setVisible(true);
    }

    public <T extends Shape> void update(int i, int j, T element) {
        if (element instanceof Circle)
            this.circles.get(i).get(j).setVisible(true);
        else if (element instanceof Rectangle)
            this.rectangles.get(i).get(j).setVisible(true);
    }

}

