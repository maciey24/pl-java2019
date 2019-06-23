package main.model;

import javafx.scene.shape.Shape;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Data
@Repository
public class Game {
    private Turn turn = Turn.CIRCLE;
    private Shape[][] array = new Shape[3][3];

    public void switchTurn() {
        if (this.getTurn() == Turn.CIRCLE) {
            this.turn = Turn.RECTANGLE;
        } else this.turn = Turn.CIRCLE;
    }

    public void setElement(int i, int j, Shape element) {
        this.array[i][j] = element;
    }

    public Shape getElement(int i, int j) {
        return this.array[i][j];
    }

    public void setElement(GridIndex gridIndex, Shape toChange) {
        this.setElement(gridIndex.getI(), gridIndex.getJ(), toChange);
    }
}
