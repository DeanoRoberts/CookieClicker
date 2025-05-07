import javax.swing.*;
import java.awt.*;

/**
 * FallingCookie
 * Represents a small cookie image that falls down the screen when the  cookie is clicked.
 */
public class FallingCookie {

    // Reference to the game window
    private final GameView window;

    // Falling cookie image
    private final Image cookie;

    // Position and speed
    private final int x;
    private int y;
    private final int dy;

    // Constants
    private static final int MAX_SPEED = 8;
    private final int windowWidth;

    //Constructor
    public FallingCookie(GameView window) {
        this.window = window;
        this.windowWidth = 700;

        this.cookie = new ImageIcon("Resources/object/cookie.png").getImage();
        this.x = (int) (Math.random() * windowWidth);
        this.y = 0;                      // Start at top of screen
        this.dy = MAX_SPEED;            // Constant downward speed
    }

    // A method to makes each cookie fall
    public void Fall() {
        this.y += dy;
    }

    // Draws the  falling cookie
    public void draw(Graphics g) {
        g.drawImage(cookie, x, y, 50, 50, window);  // Scaled size for visibility
    }

    // Returns the  y-position of the cookie
    public int getY() {
        return y;
    }
}