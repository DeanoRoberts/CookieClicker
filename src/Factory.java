// Cookie Clicker by Deano Roberts
import javax.swing.*;
import java.awt.*;

// Displays a factory image
public class Factory {

    // Factory Image
    private final Image image;

    // Reference to the game window
    private final GameView window;

    // Dimensions for scaling the image
    private final int FACTORY_IMAGE_WIDTH = 144;
    private final int FACTORY_IMAGE_HEIGHT = 144;

    // Constructor
    public Factory(GameView window) {
        this.window = window;
        this.image = new ImageIcon("Resources/object/CookieFactory.png").getImage();
    }

    // Draws the factory image at a specific (x, y) and size
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image,              // Image to draw
                x, y,              // Top-left corner coordinates
                FACTORY_IMAGE_WIDTH, FACTORY_IMAGE_HEIGHT,  // Scaled width and height
                window);           // Component to draw on
    }
}