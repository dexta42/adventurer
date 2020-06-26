package fr.exercice;

import fr.exercice.Object.Coordinate;
import fr.exercice.Object.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventurerApplication {

    private static final String MAP_FILE_PATH = "C:\\Dev\\Projets\\adventurer\\src\\main\\resources\\carte.txt";
    private static final String TRAJECTORY_FILE_PATH = "C:\\Dev\\Projets\\adventurer\\src\\main\\resources\\trajectory.txt";
    private static Map map;
    private static char[] directionsArray;

    public static void main(String[] args) throws Exception {
        loadMap();
        Coordinate coordinate = processTrajectory(TRAJECTORY_FILE_PATH);
        System.out.println("Coordonnée finale : " + coordinate.toString());
    }

    public static void loadMap() throws IOException {
        File file = new File(MAP_FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> MAP;
        MAP = new ArrayList<String>();
        while ((st = br.readLine()) != null) {
            MAP.add(st);
        }
        map = new Map(MAP);
    }

    public static Coordinate processTrajectory(String trajectoryFilePath) throws Exception {
        File file = new File(trajectoryFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Coordinate coordinate = new Coordinate(br.readLine());
        directionsArray = br.readLine().toCharArray();

        if (!map.isValidCoordinate(coordinate.getAbscissa(), coordinate.getOrdonate())) {
            throw new Exception("Coordonnées de départ non valide");
        }

        for (char direction : directionsArray) {
            int newOrdonate;
            int newAbscissa;
            switch (direction) {
                case 'N':
                    newOrdonate = coordinate.getOrdonate() - 1;
                    if (map.isValidCoordinate(coordinate.getAbscissa(), newOrdonate)) {
                        coordinate.setOrdonate(newOrdonate);
                    } else {
                        throw new Exception("La trajectoire passe par une case non valide");
                    }
                    break;
                case 'S':
                    newOrdonate = coordinate.getOrdonate() + 1;
                    if (map.isValidCoordinate(coordinate.getAbscissa(), newOrdonate)) {
                        coordinate.setOrdonate(newOrdonate);
                    } else {
                        throw new Exception("La trajectoire passe par une case non valide");
                    }
                    break;
                case 'E':
                    newAbscissa = coordinate.getAbscissa() + 1;
                    if (map.isValidCoordinate(newAbscissa, coordinate.getOrdonate())) {
                        coordinate.setAbscissa(newAbscissa);
                    } else {
                        throw new Exception("La trajectoire passe par une case non valide");
                    }
                    break;
                case 'O':
                    newAbscissa = coordinate.getAbscissa() - 1;
                    if (map.isValidCoordinate(newAbscissa, coordinate.getOrdonate())) {
                        coordinate.setAbscissa(newAbscissa);
                    } else {
                        throw new Exception("La trajectoire passe par une case non valide");
                    }
                    break;
            }
        }
        return coordinate;
    }
}
