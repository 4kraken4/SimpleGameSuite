package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

class PolygonWithLabels extends JFrame {

    private JLabel[] pointLabels;
    private JLabel[] lineLabels;
    private final Point[] points;
    private double[] lineDistances;

    public PolygonWithLabels() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Polygon with Labels");
        setPreferredSize(new Dimension(400, 400));

        // Define the polygon points
        points = new Point[]{
            new Point(100, 100),
            new Point(200, 50),
            new Point(300, 100),
            new Point(350, 200),
            new Point(250, 250),
            new Point(150, 200)
        };

        // Calculate line distances
        calculateLineDistances();

        // Create the point labels
        createPointLabels();

        // Create the line labels
        createLineLabels();

        // Set layout and add labels
        setLayout(null);
        addLabels(pointLabels);
        addLabels(lineLabels);

        // Add click listeners to line labels
        addLineLabelListeners();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateLineDistances() {
        lineDistances = new double[points.length];

        for (int i = 0; i < points.length; i++) {
            int nextIndex = (i + 1) % points.length;
            double distance = points[i].distance(points[nextIndex]);
            lineDistances[i] = distance;
        }
    }

    private void createPointLabels() {
        pointLabels = new JLabel[points.length];

        for (int i = 0; i < points.length; i++) {
            JLabel label = new JLabel();
            label.setBounds(points[i].x - 5, points[i].y - 5, 10, 10);
            label.setOpaque(true);
            label.setBackground(Color.RED);
            pointLabels[i] = label;
        }
    }

    private void createLineLabels() {
        lineLabels = new JLabel[points.length];

        for (int i = 0; i < points.length; i++) {
            int nextIndex = (i + 1) % points.length;

            double distance = lineDistances[i];

            int labelX = (points[i].x + points[nextIndex].x) / 2;
            int labelY = (points[i].y + points[nextIndex].y) / 2;

            // Calculate label position
            int dx = points[nextIndex].x - points[i].x;
            int dy = points[nextIndex].y - points[i].y;
            int offsetX = dy > 0 ? -15 : 5;
            int offsetY = dx < 0 ? -10 : 0;

            JLabel label = new JLabel(String.format("%.2f", distance));
            label.setBounds(labelX + offsetX, labelY + offsetY, 50, 20);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            lineLabels[i] = label;
        }
    }

    private void addLabels(JLabel[] labels) {
        for (JLabel label : labels) {
            add(label);
        }
    }

    private void addLineLabelListeners() {
        for (int i = 0; i < lineLabels.length; i++) {
            final int lineIndex = i;

            lineLabels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    double distance = lineDistances[lineIndex];
                    JOptionPane.showMessageDialog(null, "Distance: " + distance);
                }
            });
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < points.length; i++) {
            int nextIndex = (i + 1) % points.length;

            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(new Line2D.Double(points[i].x, points[i].y, points[nextIndex].x, points[nextIndex].y));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PolygonWithLabels::new);
    }
}
