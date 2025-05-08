// Cookie Clicker by Deano Roberts
import javax.swing.*;
import java.awt.*;

// GameView, Handles the visual components of the Cookie Clicker
public class GameView extends JFrame {

    // Window dimensions
    public static final int DEMO_WIDTH = 700;
    public static final int DEMO_HEIGHT = 500;

    private final Game game;
    private final Image background;

    // Constructor
    public GameView(Game game) {
        this.game = game;

        this.setSize(DEMO_WIDTH, DEMO_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Cookie Clicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Load background image
        this.background = new ImageIcon("Resources/object/thebg.jpg").getImage();
    }

    // Paints
    @Override
    public void paint(Graphics g) {
        // Draw background image
        g.drawImage(background, 0, 0, this);

        // Draw game instructions
        g.setColor(Color.WHITE);
        g.drawString("Today you will be playing Cookie Clicker! Click the Cookie!", 100, 100);

        // Draw cookie counter
        g.drawString("Cookies: " + game.getPoints(), 150, 160);

        // Draw Granny info
        g.drawString("Granny Count: " + game.getNumGranny(), 420, 290);
        g.drawString("Costs $" + game.getGrannyCost(), 420, 270);

        // Draw Factory info
        g.drawString("Factory Count: " + game.getNumFactory(), 420, 490);
        g.drawString("Costs $" + game.getFactoryCost(), 420, 470);

        // Draw falling cookies
        for (FallingCookie c : game.getFallingCookies()) {
            c.draw(g);
        }

        // Draw static elements
        game.getTheCookie().draw(g, 90, 180);
        game.getGranny().draw(g, 400, 120);
        game.getFactory().draw(g, 400, 320);
    }
}