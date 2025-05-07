import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

// Game, Handles all logic for Cookie Clicker

public class Game implements ActionListener, MouseListener, MouseMotionListener {

    // Instance variables for game elements
    private final Granny granny;
    private final Factory factory;
    private final TheCookie theCookie;

    // Player stats
    private int clickNum;
    private int points;

    // Upgrades
    private int numGranny;
    private int numFactory;

    // Costs
    private int grannyCost;
    private int factoryCost;

    // Game window and timer
    private GameView window;
    private final Timer clock;
    private int intervol;

    // List of falling cookies to animate
    private final ArrayList<FallingCookie> fallingCookies = new ArrayList<>();

    //Constructor
    public Game() {
        this.granny = new Granny(window);
        this.factory = new Factory(window);
        this.theCookie = new TheCookie(window);

        this.clickNum = 0;
        this.points = 0;
        this.numGranny = 0;
        this.numFactory = 0;

        this.grannyCost = 10;
        this.factoryCost = 100;

        this.intervol = 0;

        // Initialize and display game window
        this.window = new GameView(this);
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);

        // Start the game loop
        clock = new Timer(100, this);
        clock.start();
    }

    public Granny getGranny() {
        return granny;
    }

    public Factory getFactory() {
        return factory;
    }

    public TheCookie getTheCookie() {
        return theCookie;
    }

    public ArrayList<FallingCookie> getFallingCookies() {
        return fallingCookies;
    }

    //MouseListener event handlers

    @Override
    public void mouseClicked(MouseEvent e) {
        int xVal = e.getX();
        int yVal = e.getY();

        // TheCookie image is drawn at (90, 180) and scaled to  242x246
        int centerX = 90 + 242 / 2;
        int centerY = 180 + 246 / 2;
        int radius = 242 / 2;

        double distance = Math.sqrt(Math.pow(xVal - centerX, 2) + Math.pow(yVal - centerY, 2));

        // Check if main cookie is clicked
        if (distance <= radius) {
            clickNum++;
            points++;
            System.out.println(points);

            // Spawn's a falling cookie
            fallingCookies.add(new FallingCookie(window));
        }

        // Check if Granny is clicked
        if (xVal >= 400 && xVal <= (400 + 133) && yVal >= 120 && yVal <= (120 + 133)) {
            //Sees if player can buy then updates
            if (points >= grannyCost) {
                numGranny++;
                points -= grannyCost;
                grannyCost = (grannyCost * numGranny) + 5;

                if (points < 0) points = 0;
            }
        }

        // Check if Factory is clicked
        if (xVal >= 400 && xVal <= (400 + 144) && yVal >= 320 && yVal <= (320 + 144)) {
            //Sees if player can buy then updates
            if (points >= factoryCost) {
                numFactory++;
                points -= factoryCost;
                factoryCost = (factoryCost * numFactory) + 30;

                if (points < 0) points = 0;
            }
        }

        // Repaint screen after changes
        window.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not Used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not Used
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not Used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not Used
    }


    // MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        // Not Used
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Not Used
    }

    // Getters for display values
    public int getPoints() {
        return points;
    }

    public int getNumGranny() {
        return numGranny;
    }

    public int getGrannyCost() {
        return grannyCost;
    }

    public int getNumFactory() {
        return numFactory;
    }

    public int getFactoryCost() {
        return factoryCost;
    }

    // Updates score from passive income + falling cookies
    @Override
    public void actionPerformed(ActionEvent e) {
        intervol++;
        // Passive cookie production
        if (intervol % 10 == 0) {
            if (numGranny > 0) {
                points += (numGranny * 5);
            }
            if (numFactory > 0) {
                points += numFactory * 10;
            }
        }

        // Update falling cookies
        for (int i = fallingCookies.size() - 1; i >= 0; i--) {
            FallingCookie c = fallingCookies.get(i);
            c.Fall();

            // Remove cookie if it's off the bottom of the screen
            if (c.getY() > GameView.DEMO_HEIGHT) {
                fallingCookies.remove(i);
            }
        }

        window.repaint();
    }

    // Launch's game
    public static void main(String[] args) {
        Game md = new Game();
    }
}