package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coord {
    double value;

    public boolean between(double a, double b) {
        return (a <= value && value <= b) || (b <= value && value <= a);
    }
}
