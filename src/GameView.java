
import javax.swing.*;
import java.awt.*;

/**
 * MouseDemo and MouseDemoView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * This demo implements the MouseListener and MouseMotionListener interfaces. The front-end listens for the
 * mouse events, which in turn call the methods that are implemented in the back-end.
 */

public class GameView extends JFrame {


    public static final int DEMO_WIDTH = 700;
    public static final int DEMO_HEIGHT = 500;

    private Game game;
    private Image background;



    public GameView(Game game) {
        this.game = game;

        this.setSize(DEMO_WIDTH, DEMO_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Mouse Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.background = new ImageIcon("Resources/object/thebg.jpg").getImage();
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawImage(background, 0,0,this);
        // Set the background of the Frame to LIGHT_GRAY


        String instructions = "  Today you will be playing Cookie clicker!\n" + "" + "Click the Cookie!";
        g.setColor(Color.WHITE);
        g.drawString(instructions, 100, 100);
        // Cookie counter
        String p = "Cookies: " + game.getPoints();
        g.setColor(Color.WHITE);
        g.drawString(p, 150, 160);

        // Granny Counter
        String grannyCounter = "Granny Count: " + game.getNumGranny();
        g.setColor(Color.WHITE);
        g.drawString(grannyCounter, 420, 290);

       // Granny cost counter
        String grannyCostCounter = "Costs $" + game.getGrannyCost();
        g.setColor(Color.WHITE);
        g.drawString(grannyCostCounter, 420, 270);

        // Factory Counter
        String factoryCounter = "Factory Count: " + game.getNumFactory();
        g.setColor(Color.WHITE);
        g.drawString(factoryCounter, 420, 490);

        // Factory cost counter
        String factoryCostCounter = "Costs $" + game.getFactoryCost();
        g.setColor(Color.WHITE);
        g.drawString(factoryCostCounter, 420, 470);








        // Note: getInsets().top just finds where the Title Bar ends and the usable area starts

        // Set the Color of the information box to WHITE
//        g.setColor(Color.WHITE);
//        g.fillRect(INFO_RECT_TOP_LEFT_X, INFO_RECT_TOP_LEFT_Y,
//                INFO_RECT_WIDTH, INFO_RECT_HEIGHT);

        // Set the Color of information Strings to Black
        g.setColor(Color.BLACK);

        // Draw the Strings onto the Frame (inside of the information box)
        for (FallingCookie c: game.getFallingCookies())
        {
            c.draw(g);
        }
        // Have the ball draw itself
        game.getCookie().draw(g);
        game.getTheCookie().draw(g, 90, 180);
        game.getGranny().draw(g,400, 120);
        game.getFactory().draw(g, 400, 320);
        System.out.println("Falling cookies: " + game.getFallingCookies().size());




    }
}
