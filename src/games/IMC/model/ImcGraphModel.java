package games.IMC.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IMCGraphModel {

    public List<Integer> getMirrorSelectedEdges() {
        return mirrorSelectedEdges;
    }

    public void setMirrorSelectedEdges(List<Integer> mirrorSelectedEdges) {
        this.mirrorSelectedEdges = mirrorSelectedEdges;
    }

    public List<Integer> getCorrectEdges() {
        return correctEdges;
    }

    public void setCorrectEdges(List<Integer> correctEdges) {
        IMCGraphModel.correctEdges = correctEdges;
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
        IMCGraphModel.numCities = numCities;
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
                int value = (int) (Math.random() * 91) + 10;
                matrix[r][c] = value;
                matrix[c][r] = value;
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
                    if (getMirrorSelectedEdges().contains(c * numCities + r)) {
                        getMirrorSelectedEdges().remove(Integer.valueOf(c * numCities + r));
                    } else {
                        getMirrorSelectedEdges().add(c * numCities + r);
                    }
                    return r * numCities + c;
                }
            }
        }
        return -1;
    }

    public boolean isClickedOnLine(int mouseX, int mouseY, int x1, int y1, int x2, int y2) {
        final int CLICK_TOLERANCE = 10;
        return getDistanceFromPointToLine(mouseX, mouseY, x1, y1, x2, y2) < CLICK_TOLERANCE;
    }

    public double getDistanceFromPointToLine(int x, int y, int x1, int y1, int x2, int y2) {
        return Math.abs((y2 - y1) * x - (x2 - x1) * y + x2 * y1 - y2 * x1)
                / Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public static void primMST(int[][] graph) {
        int vertices = graph.length;
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] mstSet = new boolean[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        // System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            // System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            correctEdges.add(i * numCities + parent[i]);
        }
    }

    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int length = key.length;
        for (int v = 0; v < length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static int numCities = 0;
    public final static int GAME_ID = 5;
    private int[][] matrix = new int[numCities][numCities];
    private List<Point> cityPoints = new ArrayList<>();
    private List<Integer> selectedEdges = new ArrayList<>();
    private List<Integer> mirrorSelectedEdges = new ArrayList<>();
    private static List<Integer> correctEdges = new ArrayList<>();
}
