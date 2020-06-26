package fr.exercice;


import fr.exercice.Object.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerApplicationTest {

    private static String TEST1_FILE_PATH = "C:\\Dev\\Projets\\adventurer\\src\\main\\resources\\test\\test1.txt";
    private static String TEST2_FILE_PATH = "C:\\Dev\\Projets\\adventurer\\src\\main\\resources\\test\\test2.txt";

    @Test
    public void test1() throws Exception {
        AdventurerApplication.loadMap();
        Coordinate coordinate = AdventurerApplication.processTrajectory(TEST1_FILE_PATH);
        assertEquals(coordinate.toString(), "(9,2)");
    }

    @Test
    public void test2() throws Exception {
        AdventurerApplication.loadMap();
        Coordinate coordinate = AdventurerApplication.processTrajectory(TEST2_FILE_PATH);
        assertEquals(coordinate.toString(), "(7,5)");
    }
}
