import javax.swing.*;
import java.awt.*;

/**
 * Granny
 * Represents a clickable granny upgrade in the Cookie Clicker game.
 * When purchased, grannies increase cookie production.
 */
public class Granny {

    // Granny image
    private final Image image;

    // Reference to the game window
    private final GameView window;

    // Original image dimensions
    private final int GRANNY_IMAGE_WIDTH = 295;
    private final int GRANNY_IMAGE_HEIGHT = 440;

    //Constructor
    public Granny(GameView window) {
        this.window = window;
        this.image = new ImageIcon("Resources/object/granny.png").getImage();
    }

    // Draws the granny image
    public void draw(Graphics g, int x, int y) {
        g.drawImage(
                image,
                x, y,                                 // Position
                GRANNY_IMAGE_WIDTH / 4,               // Scaled width
                GRANNY_IMAGE_HEIGHT / 4,              // Scaled height
                window
        );
    }
}