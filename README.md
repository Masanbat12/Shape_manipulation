# Shape_manipulation project:
#### This Java project, part of the mavenproject1 package, includes several classes to create a simple animation frame application with Swing. The application features different animations, including moving spirals and a Rubik's cube, and an interactive Rubik's cube component where users can select colors.
## Classes
### AnimationFrame: Main application window that switches between different animations.
### MovingSpiral: A JPanel subclass that displays a continuously rotating spiral.
### MovingRubiksCube: A JPanel subclass that shows a rotating Rubik's cube animation.
### InteractiveRubiksCube: A JFrame subclass that allows interactive color selections for a Rubik's cube.
### MovingRubiksCube_2: A JPanel subclass used in InteractiveRubiksCube for displaying the Rubik's cube.
## Requirements
### Java Development Kit (JDK)
### NetBeans IDE
### Maven (usually bundled with NetBeans)
## Setup and Running in NetBeans
Clone or Download the Project: Obtain the project files and save them to your local machine.
Open NetBeans: Launch the NetBeans IDE.
Open the Project:
Go to File > Open Project.
Navigate to the directory where you saved the project files.
Select the project and click Open Project.
Resolve Dependencies: Ensure all Maven dependencies are correctly downloaded and configured.
Run the Application:
Right-click on the project in the Projects tab.
Select Run to start the application.
## Connection with IntelliJ IDEA
To use this project in IntelliJ IDEA (another Java IDE), follow these steps:

Open IntelliJ IDEA: Launch the IntelliJ IDEA IDE.
Import Project:
Go to File > Open.
Navigate to the project directory.
Select the project and click Open.
Maven Integration: IntelliJ should automatically detect the Maven project and load dependencies.
Run the Application:
Locate the main method in the AnimationFrame class.
Right-click and select Run 'AnimationFrame.main()'.

## Note
#### The project structure follows Maven standards, so it should be compatible with most Java IDEs that support Maven. Ensure that your JDK version is compatible with the project's JDK requirements.

## Pictures to illustrate the code product:
<img width="300" alt="Screenshot 2023-12-27 121752" src="https://github.com/Masanbat12/Shape_manipulation/assets/93978448/c3def639-6386-46b4-b1d0-37ec66f35a22">
<img width="300" alt="Screenshot 2023-12-27 121823" src="https://github.com/Masanbat12/Shape_manipulation/assets/93978448/d82b87da-8e4c-4008-92aa-af1595ef8a49">
<img width="300" alt="Screenshot 2023-12-27 122050" src="https://github.com/Masanbat12/Shape_manipulation/assets/93978448/f439a54c-0cb9-4c9e-be5f-066e962addef">

## Explanation on the classes:
#### The MovingSpiral class,
part of the mavenproject1 package, is a Java Swing component designed to create and display a dynamic, animated spiral. This class extends JPanel and implements the Runnable interface, indicating it is designed to be run on a separate thread.

Key Features and Behavior:

Initialization: In the constructor, the spiral's background is set to white, and a new thread is started, implying that the spiral's animation runs independently of the main application thread.

Graphics Rendering:

The paintComponent method, overridden from JPanel, is used to draw the spiral.
It uses Graphics2D for advanced drawing capabilities.
The spiral is created using a loop that draws lines from the center to outward, gradually increasing the radius and changing the angle.
The color of each line segment changes gradually, creating a rainbow effect. This is achieved by varying the hue value in the HSB (Hue, Saturation, Brightness) color model.
Animation Logic:

The run method, part of the Runnable implementation, contains a loop that continuously updates the angle and repaints the panel to animate the spiral.
The Thread.sleep(300) call slows down the animation, making it visible and smooth.
Execution:

The main method demonstrates how to use this class in a standalone application.
It creates a JFrame, sets its default close operation, size, and adds an instance of MovingSpiral to the frame before making it visible.
Overall, MovingSpiral is a graphical Java component that creates a visually appealing, continuously updating spiral animation. It demonstrates the use of Java Swing, multi-threading, and custom painting in graphics programming.

#### The MovingRubiksCube class,
part of the mavenproject1 package, is a Java Swing component designed for creating a simulated animation of a Rubik's cube. This class extends JPanel and implements the Runnable interface, which allows it to run the animation in a separate thread.

Key Characteristics and Behavior:

Color Definition: The class defines an array of Color objects representing the colors of the Rubik's cube faces.

Thread Initialization: In the constructor, a new thread is started, indicating that the cube's animation operates independently of the main application thread.

Graphical Rendering:

The paintComponent method, which is overridden from JPanel, handles the drawing of the cube.
Graphics2D is used for more advanced drawing capabilities.
The cube is represented in a simplified 2D form, but the rotation and color arrangement give it a 3D appearance.
The cube size is dynamically calculated based on the panel's dimensions to maintain proportionality.
Animation Logic:

The run method contains a loop for the animation, continually updating the angles (angleX and angleY) to create the rotation effect.
The repaint method is called to redraw the cube with updated angles, giving the illusion of rotation.
Thread.sleep(10) is used to control the speed of the animation, making it smooth and visually coherent.
Rotation Mechanics:

The cube's rotation is simulated by updating angleY (and angleX, although it is not used in paintComponent), giving the cube a spinning effect around its center.
In summary, MovingRubiksCube is a graphical Java component that creates an animated, rotating Rubik's cube using Java Swing. It demonstrates the application of multi-threading, custom painting, and simple 2D graphics transformations to simulate a 3D effect in a Java Swing application.

#### The InteractiveRubiksCube class, 
in the mavenproject1 package is a Java Swing application designed to provide an interactive experience with a simulated Rubik's Cube. This class extends JFrame, indicating it's a GUI window, and contains an inner class MovingRubiksCube_2, which is a JPanel for displaying the cube.

Key Features and Functionality:

Window Setup: The constructor sets up the main window, including title, size, close operation, and layout.

Rubik's Cube Panel:

A MovingRubiksCube_2 object (rubiksCubePanel) is created and added to the center of the frame.
This panel is responsible for displaying the animated Rubik's Cube.
Color Selection Panel:

A color selection panel is created with a grid layout to host color buttons.
Buttons for different colors (Red, Blue, Green, Yellow, Orange, White) are added to this panel, allowing the user to select colors for the Rubik's Cube.
Color Selection Logic:

The colorCounts map tracks the number of times each color is selected.
The addColorButton method adds a button for each color to the panel and defines the action to be performed when a color is selected.
Once a color is selected, updateRubiksCubeColors updates the colors on the Rubik's Cube.
Limiting Color Selections:

The application restricts the user to select up to 6 colors in total.
If the limit is reached, a message is displayed.
Interactive Rubik's Cube (Inner Class: MovingRubiksCube_2):

This JPanel subclass animates a Rubik's Cube with rotating faces.
The setColors method allows changing the colors of the cube's faces based on user selection.
The paintComponent method is overridden for custom drawing of the cube.
The run method contains an infinite loop for animation, continuously updating the cube's rotation angle and triggering a repaint.
Running the Application: The main method uses SwingUtilities.invokeLater to ensure that the GUI is created and updated in the Event Dispatch Thread, which is the correct practice for Swing applications.

Overall, InteractiveRubiksCube demonstrates the use of Swing components, event handling, and custom graphics for creating an interactive and dynamic GUI application. It allows users to interact with a simulated Rubik's Cube, altering its appearance by selecting different colors.
