package games.SP.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;

public class spGraphModel {

    /**
     * @return the mirrorSelectedEdges
     */
    public List<Integer> getMirrorSelectedEdges() {
        return mirrorSelectedEdges;
    }

    /**
     * @param mirrorSelectedEdges the mirrorSelectedEdges to set
     */
    public void setMirrorSelectedEdges(List<Integer> mirrorSelectedEdges) {
        this.mirrorSelectedEdges = mirrorSelectedEdges;
    }

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
                int value = (int) (Math.random() * 41) + 5;
                matrix[r][c] = value;
                matrix[c][r] = value;
            }
        }
        for (int i = 0; i < numCities; i++) {
            int r = (int) (Math.random() * numCities - 1);
            int c = (int) (Math.random() * numCities - 1);
            matrix[r][c] = 0;
            matrix[c][r] = 0;
        }
        matrix[numCities - 1][0] = 0;
        matrix[0][numCities - 1] = 0;
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
                    if(mirrorSelectedEdges.contains(c* numCities + r))
                    {
                      mirrorSelectedEdges.remove(Integer.valueOf(c* numCities + r));
                    }
                    else{
                     mirrorSelectedEdges.add(c* numCities + r);
                    }
                  
                   return r* numCities + c;
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

    public static void getShortestPaths(int[][] adjacencyMatrix, int startNode) {
        int numCities = adjacencyMatrix.length;
        int[] distances = new int[numCities];
        boolean[] visited = new boolean[numCities];
        int[] previousEdges = new int[numCities];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(numCities, Comparator.comparingInt(node -> distances[node]));
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;

            for (int neighborNode = 0; neighborNode < numCities; neighborNode++) {
                int edgeWeight = adjacencyMatrix[currentNode][neighborNode];
                if (edgeWeight != 0 && !visited[neighborNode]) {
                    int edgeNumber = currentNode * numCities + neighborNode;
                    int newDistance = distances[currentNode] + edgeWeight;
                    if (newDistance < distances[neighborNode]) {
                        distances[neighborNode] = newDistance;
                        previousEdges[neighborNode] = edgeNumber;

                        if (!queue.contains(neighborNode)) {
                            queue.add(neighborNode);
                        }
                    }
                }
            }
        }
        int targetNode = numCities - 1;
        if (distances[targetNode] == Integer.MAX_VALUE) {
            JOptionPane.showMessageDialog(null, " unreachable");
        } else {
            int previousEdge = previousEdges[targetNode];
            while (previousEdge != 0) {
                int previousNode = (previousEdge - 1) / numCities;
                
                correctEdges.add(previousEdge);
                previousEdge = previousEdges[previousNode];
            }

        }

    }

    private static final int INFINITY = Integer.MAX_VALUE;
    private static int numCities = 0;
    private int[][] matrix = new int[numCities][numCities];
    private List<Point> cityPoints = new ArrayList<>();
    private List<Integer> selectedEdges = new ArrayList<>();
    private List<Integer> mirrorSelectedEdges =new ArrayList<>();
    private static List<Integer> correctEdges = new ArrayList<>();
}
