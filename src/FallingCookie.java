import javax.swing.*;
import java.awt.*;

public class FallingCookie
{
    private GameView window;
    private Image cookie;
    private int x, y, dy;
    private int windowWidth ;
    private int windowHeight;
    private static final int MAX_SPEED = 8;
    private static final int COOKIE_WIDTH = 288;
    private static final int COOKIE_HEIGHT = 256;

    public FallingCookie( GameView window)
    {
        this.window = window;
        this.windowWidth = 700;
        this.windowHeight = 500;

        cookie = new ImageIcon("Resources/object/cookie.png").getImage();

        this.x = (int)(Math.random() * windowWidth);
        this.y = 0;
        this.dy = MAX_SPEED;

    }

    public  void Fall()
    {
        this.y += dy;
    }

    public void draw(Graphics g)
    {
        g.drawImage(cookie, x, y, 50, 50 , window);
    }

    public int getY()
    {
        return y;
    }





}
