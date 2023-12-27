package mavenproject1;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InteractiveRubiksCube extends JFrame {
    private MovingRubiksCube_2 rubiksCubePanel;
    private Map<Color, Integer> colorCounts = new HashMap<>();
    private int totalSelections = 0;

    public InteractiveRubiksCube() {
        setTitle("Interactive Rubik's Cube");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        rubiksCubePanel = new MovingRubiksCube_2();
        add(rubiksCubePanel, BorderLayout.CENTER);

        JPanel colorSelectionPanel = new JPanel(new GridLayout(1, 6));
        initializeColorCounts();
        addColorButton("Red", Color.RED, colorSelectionPanel);
        addColorButton("Blue", Color.BLUE, colorSelectionPanel);
        addColorButton("Green", Color.GREEN, colorSelectionPanel);
        addColorButton("Yellow", Color.YELLOW, colorSelectionPanel);
        addColorButton("Orange", Color.ORANGE, colorSelectionPanel);
        addColorButton("White", Color.WHITE, colorSelectionPanel);
        add(colorSelectionPanel, BorderLayout.NORTH);
    }

    private void initializeColorCounts() {
        colorCounts.put(Color.RED, 0);
        colorCounts.put(Color.BLUE, 0);
        colorCounts.put(Color.GREEN, 0);
        colorCounts.put(Color.YELLOW, 0);
        colorCounts.put(Color.ORANGE, 0);
        colorCounts.put(Color.WHITE, 0);
    }

    private void addColorButton(String name, Color color, JPanel panel) {
        JButton button = new JButton(name);
        button.setBackground(color);
        button.addActionListener(e -> {
            if (totalSelections < 6) {
                colorCounts.put(color, colorCounts.get(color) + 1);
                totalSelections++;
                updateRubiksCubeColors();
            } else {
                JOptionPane.showMessageDialog(this, "You can only select up to 6 colors.");
            }
        });
        panel.add(button);
    }

    private void updateRubiksCubeColors() {
        Color[] colors = new Color[6];
        int index = 0;

        for (Map.Entry<Color, Integer> entry : colorCounts.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                if (index < 6) {
                    colors[index++] = entry.getKey();
                }
            }
        }

        while (index < 6) {
            colors[index++] = Color.GRAY; // Fill the rest with gray
        }

        rubiksCubePanel.setColors(colors);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InteractiveRubiksCube().setVisible(true));
    }
}


class MovingRubiksCube_2 extends JPanel implements Runnable {
    private Color[] faceColors = new Color[6];
    private double angle = 0;

    public MovingRubiksCube_2() {
        // Set default colors
        for (int i = 0; i < 6; i++) {
            faceColors[i] = Color.GRAY;
        }
        new Thread(this).start();
    }

    // Modified setColors method to accept Color array directly
    public void setColors(Color[] newColors) {
        System.arraycopy(newColors, 0, faceColors, 0, newColors.length);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int cubeSize = Math.min(getWidth(), getHeight()) / 6; // Adjust size for visibility
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Apply rotation to the whole graphics context
        g2d.rotate(angle, xCenter, yCenter);

        // Draw the six faces of the cube
        for (int i = 0; i < 6; i++) {
            g2d.setColor(faceColors[i]);

            // Calculate position for each face
            int x = xCenter + (int) (cubeSize * 1.5 * Math.cos(angle + i * Math.PI / 3));
            int y = yCenter + (int) (cubeSize * 1.5 * Math.sin(angle + i * Math.PI / 3));

            // Draw each face as a square
            g2d.fillRect(x - cubeSize / 2, y - cubeSize / 2, cubeSize, cubeSize);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                angle += Math.PI / 180;
                repaint();
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
