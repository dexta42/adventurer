package fr.exercice.Object;

import java.util.List;

public class Map {

    private static final char WOOD_CASE = '#';
    private List<String> mapMatrix;
    private int height;
    private int width;

    public Map(List<String> mapMatrix) {
        this.mapMatrix = mapMatrix;
        this.height = mapMatrix.size();
        this.width = mapMatrix.get(0).length();
    }

    public char getCaseFromCoordinates(int abscissa, int ordinate) {
        return mapMatrix.get(ordinate).charAt(abscissa);
    }

    public Boolean isValidCoordinate(int abscissa, int ordinate) {
        return 0 <= abscissa && abscissa < width &&
                0 <= ordinate && ordinate < height &&
                getCaseFromCoordinates(abscissa, ordinate) != WOOD_CASE;

    }

    public List<String> getMapMatrix() {
        return mapMatrix;
    }

    public void setMapMatrix(List<String> mapMatrix) {
        this.mapMatrix = mapMatrix;
    }

}
