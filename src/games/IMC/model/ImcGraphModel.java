package games.IMC.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ImcGraphModel {

    public List<Integer> getCorrectEdges() {
        return correctEdges;
    }

    public void setCorrectEdges(List<Integer> correctEdges) {
        this.correctEdges = correctEdges;
    }

    public int getNumCities() {
        return numCities;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public List<Point> getCityPoints() {
        return cityPoints;
    }

    public List<Integer> getSelectedEdges() {
        return selectedEdges;
    }

    public void setNumCities(int numCities) {
        this.numCities = numCities;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setCityPoints(List<Point> cityPoints) {
        this.cityPoints = cityPoints;
    }

    public void setSelectedEdges(List<Integer> selectedEdges) {
        this.selectedEdges = selectedEdges;
    }

    public void generateMatrix() {
        this.matrix = new int[numCities][numCities];
        for (int r = 0; r < numCities; r++) {
            for (int c = 0; c < r; c++) {
                matrix[r][c] = (int) (Math.random() * 91) + 10;
            }
        }
        setMatrix(matrix);
    }

    public void generateCityPoints() {
        int centerX = 250;
        int centerY = 250;
        int radius = 200;

        double angleIncrement = 2 * Math.PI / numCities;
        double angle = 0;

        for (int i = 0; i < numCities; i++) {
            int cityX = (int) (centerX + radius * Math.cos(angle));
            int cityY = (int) (centerY + radius * Math.sin(angle));
            cityPoints.add(new Point(cityX, cityY));
            angle += angleIncrement;
        }
    }

    public int getClickedEdge(int mouseX, int mouseY) {
        for (int r = 0; r < numCities; r++) {
            for (int c = 0; c < r; c++) {
                Point cityR = cityPoints.get(r);
                Point cityC = cityPoints.get(c);
                int distance = matrix[r][c];
                if (isClickedOnLine(mouseX, mouseY, cityR.x, cityR.y, cityC.x, cityC.y) && distance != 0) {
                    return r * numCities + c;
                }
            }
        }
        return -1;
    }

    public boolean isClickedOnLine(int mouseX, int mouseY, int x1, int y1, int x2, int y2) {
        final int CLICK_TOLERANCE = 5;
        return getDistanceFromPointToLine(mouseX, mouseY, x1, y1, x2, y2) < CLICK_TOLERANCE;
    }

    public double getDistanceFromPointToLine(int x, int y, int x1, int y1, int x2, int y2) {
        return Math.abs((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1) / Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }


    private int numCities = 5;
    private int[][] matrix = new int[numCities][numCities];
    private List<Point> cityPoints = new ArrayList<>();
    private List<Integer> selectedEdges = new ArrayList<>();
    private List<Integer> correctEdges = new ArrayList<>();
}
