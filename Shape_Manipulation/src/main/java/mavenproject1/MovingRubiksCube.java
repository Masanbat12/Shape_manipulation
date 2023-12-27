package mavenproject1;

import javax.swing.*;
import java.awt.*;

public class MovingRubiksCube extends JPanel implements Runnable {
    // Define colors
    private Color[] colors = {new Color(0, 155, 255), new Color(255, 215, 0), new Color(0, 128, 128),
            new Color(255, 0, 0), new Color(255, 253, 208), new Color(165, 42, 42)};
    private double angleX = 0;
    private double angleY = 0;

    public MovingRubiksCube() {
        new Thread(this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int cubeSize = Math.min(getWidth(), getHeight()) / 4; // Adjust size
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        // Translate to center
        g2d.translate(xCenter, yCenter);

        // Apply initial rotation (simulating 3D)
        g2d.rotate(angleY);

        // Draw 6 faces with different colors
        for (int i = 0; i < 6; i++) {
            g2d.setColor(colors[i]);
            int xOffset = (i % 3 - 1) * cubeSize;
            int yOffset = (i / 3 - 1) * cubeSize;

            // Simulate a face of the cube
            g2d.fill(new Rectangle(-cubeSize / 2 + xOffset, -cubeSize / 2 + yOffset, cubeSize, cubeSize));
        }

        g2d.dispose();
    }


    @Override
    public void run() {
        try {
            while (true) {
                angleX += Math.PI / 180;
                angleY += Math.PI / 180;
                repaint();
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
