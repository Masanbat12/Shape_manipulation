package mavenproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MovingSpiral extends JPanel implements Runnable {
    private double angle = 0;

    public MovingSpiral() {
        setBackground(Color.WHITE);
        new Thread(this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        double radius = 0;
        double angleIncrement = Math.PI / 90;
        double radiusIncrement = 1;

        for (int i = 0; i < 720; i++) {
            // Change color gradually
            float hue = (float) i / 720;
            Color color = Color.getHSBColor(hue, 1.0f, 1.0f);
            g2d.setColor(color);

            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            Shape line = new Line2D.Double(centerX, centerY, x, y);
            g2d.draw(line);
            angle += angleIncrement;
            radius += radiusIncrement;
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                angle += Math.PI / 180;
                repaint();
                // Increase the sleep duration to slow down the animation
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Spiral");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new MovingSpiral());
        frame.setVisible(true);
    }
}
