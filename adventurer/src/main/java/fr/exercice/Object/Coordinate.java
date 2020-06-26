package fr.exercice.Object;

public class Coordinate {

    private int abscissa;
    private int ordonate;

    public Coordinate(String Coordinate) {
        String[] CoordinateArray = Coordinate.split(",");
        this.abscissa = Integer.parseInt(CoordinateArray[0]);
        this.ordonate = Integer.parseInt(CoordinateArray[1]);
    }


    public int getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(int abscissa) {
        this.abscissa = abscissa;
    }

    public int getOrdonate() {
        return ordonate;
    }

    public void setOrdonate(int ordonate) {
        this.ordonate = ordonate;
    }

    @Override
    public String toString() {
        return "(" + abscissa + "," + ordonate + ')';
    }
}
