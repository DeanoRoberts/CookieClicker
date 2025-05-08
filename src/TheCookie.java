// Cookie Clicker by Deano Roberts
import javax.swing.*;
import java.awt.*;

// Main clickable cookie image
public class TheCookie {

    // Cookie image + reference to the window
    private final Image image;
    private final GameView window;

    // Original image dimensions
    private final int COOKIE_IMAGE_WIDTH = 533;
    private final int COOKIE_IMAGE_HEIGHT = 543;

    // Constructor
    public TheCookie(GameView window) {
        this.window = window;
        this.image = new ImageIcon("Resources/object/cookie.png").getImage();
    }

    // Draws the cookie image
    public void draw(Graphics g, int x, int y) {
        g.drawImage(
                image,
                x, y,
                (int) (COOKIE_IMAGE_WIDTH / 2.2),
                (int) (COOKIE_IMAGE_HEIGHT / 2.2),
                window
        );
    }
}