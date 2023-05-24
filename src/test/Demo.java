package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Demo extends JPanel {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int VERTEX_RADIUS = 10;
    private static final Color VERTEX_COLOR = Color.BLACK;
    private static final Color LINE_COLOR = Color.RED;
    private static final Color HOVER_COLOR = Color.BLUE;
    private static final int TOTAL_VERTICES = 10;
    private static final int MAX_ATTEMPTS = 10000;

    private List<Point> vertices;
    private List<Line> lines;
    private Line hoveredLine;
    private Random random;

    public Demo() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);

        vertices = new ArrayList<>();
        lines = new ArrayList<>();
        hoveredLine = null;
        random = new Random();

        generateVertices();
        generateLines();

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                hoveredLine = getHoveredLine(e.getPoint());
                repaint();
            }
        });
    }

    private void generateVertices() {
        for (int i = 0; i < TOTAL_VERTICES; i++) {
            int x = random.nextInt(WIDTH - VERTEX_RADIUS) + VERTEX_RADIUS / 2;
            int y = random.nextInt(HEIGHT - VERTEX_RADIUS) + VERTEX_RADIUS / 2;
            vertices.add(new Point(x, y));
        }
    }

    private void generateLines() {
        lines.clear();
        List<Point> shuffledVertices = new ArrayList<>(vertices);
        Collections.shuffle(shuffledVertices);

        int attempts = 0;
        boolean validSolution = false;
        while (!validSolution && attempts < MAX_ATTEMPTS) {
            validSolution = true;
            for (int i = 0; i < shuffledVertices.size() - 1; i++) {
                Point start = shuffledVertices.get(i);
                Point end = shuffledVertices.get(i + 1);
                Line line = new Line(start, end);
                if (checkIntersections(line, lines)) {
                    validSolution = false;
                    break;
                }
                lines.add(line);
            }
            Point start = shuffledVertices.get(shuffledVertices.size() - 1);
            Point end = shuffledVertices.get(0);
            Line line = new Line(start, end);
            if (checkIntersections(line, lines)) {
                validSolution = false;
            }
            lines.add(line);

            if (!validSolution) {
                Collections.shuffle(shuffledVertices);
                lines.clear();
                attempts++;
            }
        }

        if (!validSolution) {
            System.out.println("Unable to find a valid solution. Please adjust the parameters or try again.");
        }
    }

    private boolean checkIntersections(Line newLine, List<Line> existingLines) {
        for (Line line : existingLines) {
            if (doLinesIntersect(newLine.start, newLine.end, line.start, line.end)) {
                return true;
            }
        }
        return false;
    }

    private Line getHoveredLine(Point mousePoint) {
        for (Line line : lines) {
            if (line.isPointOnLine(mousePoint)) {
                return line;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw vertices
        g2d.setColor(VERTEX_COLOR);
        for (Point vertex : vertices) {
            int x = vertex.x - VERTEX_RADIUS / 2;
            int y = vertex.y - VERTEX_RADIUS / 2;
            g2d.fillOval(x, y, VERTEX_RADIUS, VERTEX_RADIUS);
        }

        // Draw lines
        for (Line line : lines) {
            if (line == hoveredLine) {
                g2d.setColor(HOVER_COLOR);
            } else {
                g2d.setColor(LINE_COLOR);
            }
            g2d.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
        }
    }

    private static class Line {

        private Point start;
        private Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public boolean isPointOnLine(Point point) {
            double distance = Math.abs((end.y - start.y) * point.x - (end.x - start.x) * point.y
                    + end.x * start.y - end.y * start.x) / start.distance(end);
            return distance <= 2.0; // Adjust this value as needed for the hover effect
        }
    }

    private static int orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) {
            return 0;  // Collinear
        }
        return (val > 0) ? 1 : 2; // Clockwise or Counter-clockwise
    }

    private static boolean onSegment(Point p, Point q, Point r) {
        return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
                && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }

    private static boolean doLinesIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) {
            return true;
        }

        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }

        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }

        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }

        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Demo());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
