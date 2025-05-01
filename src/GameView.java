
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

        String p = " " + game.getPoints();
        g.setColor(Color.WHITE);
        g.drawString(p, 30, 150);

        String grannyCounter = " " + game.getNumGranny();
        g.setColor(Color.WHITE);
        g.drawString(grannyCounter, 10, 200);



        // Note: getInsets().top just finds where the Title Bar ends and the usable area starts

        // Set the Color of the information box to WHITE
//        g.setColor(Color.WHITE);
//        g.fillRect(INFO_RECT_TOP_LEFT_X, INFO_RECT_TOP_LEFT_Y,
//                INFO_RECT_WIDTH, INFO_RECT_HEIGHT);

        // Set the Color of information Strings to Black
        g.setColor(Color.BLACK);

        // Draw the Strings onto the Frame (inside of the information box)

        // Have the ball draw itself
        game.getCookie().draw(g);
        game.getTheCookie().draw(g, 90, 180);
        game.getGranny().draw(g,400, 120);



    }
}
