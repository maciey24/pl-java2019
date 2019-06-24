package main.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void between() {
        Coord coord = new Coord(20);

        boolean isBetween  = coord.between(19.0, 21);

        assertTrue(isBetween);
    }

    @Test
    void between2() {
        Coord coord = new Coord(20);

        boolean isBetween  = coord.between(21, 19);

        assertTrue(isBetween);
    }

    @Test
    void between3() {
        Coord coord = new Coord(21.1);

        boolean isBetween  = coord.between(21, 19);

        assertFalse(isBetween);
    }

}