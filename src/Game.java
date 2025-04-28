import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.lang.Math.sqrt;

/**
 * MouseDemo and MouseDemoView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * This demo implements the MouseListener and MouseMotionListener interfaces. The front-end listens for the
 * mouse events, which in turn call the methods that are implemented in the back-end.
 */

public class Game implements MouseListener, MouseMotionListener {

    public static final Color[] COLORS = {Color.RED, Color.BLUE, Color.GREEN};

    // Instance Variables
    private Cookie cookie;
    private int clickNum;
    private int points;

    private GameView window;

    // Constructors
    public Game() {
        // Create a Ball with the 0 parameter constructor
        this.cookie = new Cookie();
        this.clickNum = 0;
        this.points = 0;


        // Initialize the front-end
        this.window = new GameView(this);

        // addMouseListener attaches a MouseListener object to MouseDemoView
        // addMouseMotionListener attaches a MouseMotionListener object to MouseDemoView
        // By passing "this" as the parameter, it makes this specific Instance
        // of MouseDemo the MouseListener and the MouseMotionListener, which means
        // the front-end senses the mouse, but the back-end has the methods.
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

    public Cookie getCookie()
    {
        return cookie;
    }
    public static void main(String[] args) {
        Game md = new Game();
    }

    /********************************************
     MouseListener event handlers - BEGIN
     ********************************************/

    @Override
    public void mousePressed(MouseEvent e) {

//            clickNum++;
//            cookie.setColor(COLORS[clickNum % 3]);


        // For demo purposes only
//       System.out.println("mousePressed event handler executed.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // For demo purposes only
//        System.out.println("mouseReleased event handler executed.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int xVal = e.getX();
        int yVal = e.getY();
        int centerX = cookie.getCenterX();
        int centerY = cookie.getCenterY();
        double distance = Math.sqrt(Math.pow(xVal - centerX, 2) + Math.pow(yVal - centerY, 2));

        if (distance <= cookie.getRadius()) {
            clickNum++;
            points++;
            cookie.setColor(COLORS[clickNum % COLORS.length]);
            System.out.println(points);
        }

        window.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // For demo purposes only
//        Sysem.out.println("mouseEntered event handler executed.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // For demo purposes only
//        System.out.println("mouseExited event handler executed.");
    }

    /********************************************
     MouseListener event handlers - END
     ********************************************/

    /********************************************
     MouseMotionListener event handlers - BEGIN
     ********************************************/

    @Override
    public void mouseDragged(MouseEvent e) {
//        // Have the ball follow the dragging mouse
//        // Print to terminal for demo purposes only
//        System.out.println("\t\t\texecuting mouseDragged event handler");
//
//        // Ask the input event the current location (x and y position on the Frame) of the mouse
//        int x = e.getX();
//        int y = e.getY();
//
//        // If the ball is clicked
//        if (cookie.isClicked(x, y)) {
//            // Move the ball and repaint.
//            cookie.setCenter(x, y);
//            window.repaint();
//        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // For demo purposes only
//        System.out.println("\t\t\texecuting mouseMoved event handler");
    }

    /********************************************
     MouseMotionListener event handlers - END
     ********************************************/
}