package test;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MinimumSpanningTreeUI extends JFrame {

    private GraphPanel graphPanel;
    private List<Integer> selectedEdges;
    private JButton calculateButton;

    public MinimumSpanningTreeUI() {
        setTitle("Minimum Spanning Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        graphPanel = new GraphPanel();
        graphPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int vertex = graphPanel.getVertexAt(e.getX(), e.getY());
                if (vertex != -1) {
                    graphPanel.toggleVertexSelection(vertex);
                }
            }
        });

        calculateButton = new JButton("Calculate MST");
        calculateButton.addActionListener((ActionEvent e) -> {
            calculateMST();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(graphPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        selectedEdges = new ArrayList<>();
    }

    public void addVertex(int x, int y) {
        graphPanel.addVertex(x, y);
    }

    public void addEdge(int source, int destination, int weight) {
        graphPanel.addEdge(source, destination, weight);
    }

    public void generateRandomGraph(int numVertices, int numEdges, int maxWeight, int width, int height) {
        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            addVertex(x, y);
        }

        for (int i = 0; i < numEdges; i++) {
            int source = random.nextInt(numVertices);
            int destination = random.nextInt(numVertices);
            int weight = random.nextInt(maxWeight) + 1;
            addEdge(source, destination, weight);
        }
    }

    private void calculateMST() {
        int[][] minimumSpanningTree = graphPanel.calculateMinimumSpanningTree();
        graphPanel.setTree(minimumSpanningTree);
        selectedEdges.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatLaf.setup(new FlatLightLaf());
            MinimumSpanningTreeUI ui = new MinimumSpanningTreeUI();
            // Example usage:
            ui.generateRandomGraph(3, 8, 100, 600, 400);
        });
    }
}

class GraphPanel extends JPanel {

    private List<Point> vertices;
    private List<Edge> edges;
    private int[][] tree;
    private List<Integer> selectedVertices;

    public GraphPanel() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        tree = new int[0][0];
        selectedVertices = new ArrayList<>();

        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);
    }

    public void addVertex(int x, int y) {
        vertices.add(new Point(x, y));
        repaint();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
        repaint();
    }

    public int[][] calculateMinimumSpanningTree() {
        int numVertices = vertices.size();
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        for (Edge edge : edges) {
            int source = edge.getSource();
            int destination = edge.getDestination();
            int weight = edge.getWeight();
            adjacencyMatrix[source][destination] = weight;
            adjacencyMatrix[destination][source] = weight;
        }
        int[][] minimumSpanningTree = new int[numVertices][numVertices];
        boolean[] visited = new boolean[numVertices];
        int[] parent = new int[numVertices];
        int[] key = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int i = 0; i < numVertices - 1; i++) {
            int minKeyVertex = findMinKeyVertex(key, visited);
            if (minKeyVertex < 0) {
                continue;
            }
            visited[minKeyVertex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[minKeyVertex][j] != 0 && !visited[j] && adjacencyMatrix[minKeyVertex][j] < key[j]) {
                    parent[j] = minKeyVertex;
                    key[j] = adjacencyMatrix[minKeyVertex][j];
                }
            }
        }

        // Populate the minimum spanning tree matrix
        for (int i = 1; i < numVertices; i++) {
            minimumSpanningTree[parent[i]][i] = 1;
            minimumSpanningTree[i][parent[i]] = 1;
        }

        return minimumSpanningTree;
    }

    private int findMinKeyVertex(int[] key, boolean[] visited) {
        int minKey = Integer.MAX_VALUE;
        int minKeyVertex = 0;

        for (int i = 0; i < key.length; i++) {
            if (!visited[i] && key[i] < minKey) {
                minKey = key[i];
                minKeyVertex = i;
            }
        }

        return minKeyVertex;
    }

    public void toggleVertexSelection(int vertex) {
        if (selectedVertices.contains(vertex)) {
            selectedVertices.remove(Integer.valueOf(vertex));
        } else {
            selectedVertices.add(vertex);
        }
        repaint();
    }

    public boolean isReadyToCalculateMST() {
        return selectedVertices.size() >= 2;
    }

    public int getVertexAt(int x, int y) {
        for (int i = 0; i < vertices.size(); i++) {
            Point vertex = vertices.get(i);
            if (Math.abs(vertex.getX() - x) <= 5 && Math.abs(vertex.getY() - y) <= 5) {
                return i;
            }
        }
        return -1;
    }

    public void setTree(int[][] tree) {
        this.tree = tree;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw edges as straight lines with distances on top
        for (Edge edge : edges) {
            int source = edge.getSource();
            int destination = edge.getDestination();
            int weight = edge.getWeight();

            if (source < 0 || source >= vertices.size() || destination < 0 || destination >= vertices.size()) {
                continue; // Skip invalid edges
            }

            Point sourcePoint = vertices.get(source);
            Point destinationPoint = vertices.get(destination);

            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));

            // Draw straight line
            g2d.drawLine((int) sourcePoint.getX(), (int) sourcePoint.getY(), (int) destinationPoint.getX(), (int) destinationPoint.getY());

            g2d.setColor(Color.RED);
            double midX = (sourcePoint.getX() + destinationPoint.getX()) / 2;
            double midY = (sourcePoint.getY() + destinationPoint.getY()) / 2;
            g2d.drawString(String.valueOf(weight), (float) midX, (float) midY);
        }

        // Draw vertices as black dots
        g2d.setColor(Color.BLACK);
        for (Point vertex : vertices) {
            double x = vertex.getX();
            double y = vertex.getY();
            Shape dot = new Ellipse2D.Double(x - 5, y - 5, 10, 10);
            g2d.fill(dot);
        }

        // Draw selected vertices as blue dots
        g2d.setColor(Color.BLUE);
        for (int vertex : selectedVertices) {
            if (vertex < 0 || vertex >= vertices.size()) {
                continue; // Skip invalid vertices
            }

            Point point = vertices.get(vertex);
            double x = point.getX();
            double y = point.getY();
            Shape dot = new Ellipse2D.Double(x - 5, y - 5, 10, 10);
            g2d.fill(dot);
        }

        // Draw minimum spanning tree edges with thicker green lines
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(3));
        for (int i = 0; i < tree.length; i++) {
            for (int j = i + 1; j < tree.length; j++) {
                if (i < 0 || i >= vertices.size() || j < 0 || j >= vertices.size()) {
                    continue; // Skip invalid indices
                }

                if (tree[i][j] == 1) {
                    Point sourcePoint = vertices.get(i);
                    Point destinationPoint = vertices.get(j);

                    // Draw straight line for minimum spanning tree edge
                    g2d.drawLine((int) sourcePoint.getX(), (int) sourcePoint.getY(), (int) destinationPoint.getX(), (int) destinationPoint.getY());
                }
            }
        }
    }
}

class Edge {

    private int source;
    private int destination;
    private int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
