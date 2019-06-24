package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//klasa - wrapper wskazujaca indeksy planszy
public class GridIndex {
    private int i;
    private int j;
}
