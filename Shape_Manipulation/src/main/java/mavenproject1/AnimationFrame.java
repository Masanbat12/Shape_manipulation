package mavenproject1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationFrame extends JFrame implements ActionListener {
    private JPanel currentAnimation;
    private int currentAnimationIndex = 0;

    // Declaration of the button
    private JButton openRubiksCubeButton;


    public AnimationFrame() {
        setTitle("Animation Frame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        // Initialize and add the Open Rubik's Cube button
        openRubiksCubeButton = new JButton("Open Rubik's Cube");
        openRubiksCubeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRubiksCubeWindow();
            }
        });
        add(openRubiksCubeButton, BorderLayout.NORTH);

        switchAnimation(); // Initialize the first animation
    }

    private void openRubiksCubeWindow() {
        InteractiveRubiksCube rubiksCubeFrame = new InteractiveRubiksCube();
        rubiksCubeFrame.setVisible(true);
    }

    private void switchAnimation() {
        if (currentAnimation != null) {
            remove(currentAnimation);
        }

        // Logic to switch between different animations
        if (currentAnimationIndex == 0) {
            currentAnimation = new MovingSpiral();
        } else if (currentAnimationIndex == 1) {
            currentAnimation = new MovingRubiksCube();
        }

        add(currentAnimation, BorderLayout.CENTER);
        validate();
        repaint();

        currentAnimationIndex = (currentAnimationIndex + 1) % 2; // Update for the next click
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switchAnimation();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnimationFrame().setVisible(true));
    }
}
