package main.controller;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import main.Main;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class Window {
    @FXML
    Circle c00, c01, c02,
            c10, c11, c12,
            c20, c21, c22;

    @FXML
    Rectangle r00, r01, r02,
            r10, r11, r12,
            r20, r21, r22;

    ArrayList<Shape> shapes = new ArrayList<>();

    @FXML
    public void initialize() {
        System.out.println("Window init");
        addAll(shapes);
        hideAll(shapes);
    }

    private void addAll(ArrayList<Shape> shapes) {
        shapes.add(c00);
        shapes.add(c01);
        shapes.add(c02);
        shapes.add(c10);
        shapes.add(c11);
        shapes.add(c12);
        shapes.add(c20);
        shapes.add(c21);
        shapes.add(c22);

        shapes.add(r00);
        shapes.add(r01);
        shapes.add(r02);
        shapes.add(r10);
        shapes.add(r11);
        shapes.add(r12);
        shapes.add(r20);
        shapes.add(r21);
        shapes.add(r22);
    }

    private void hideAll(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            shape.setVisible(false);
        }
    }


}

