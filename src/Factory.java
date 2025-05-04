import javax.swing.*;
import java.awt.*;

public class Factory {
    private Image image;
    private GameView window;

    private final int GRANNY_IMAGE_WIDTH = 144;
    private final int GRANNY_IMAGE_HEIGHT = 144;

    public Factory(GameView window) {
        this.window = window;
        this.image = new ImageIcon("Resources/object/CookieFactory.png").getImage();
    }




    public void draw(Graphics g, int x, int y) {

        g.drawImage(image,        // Image to draw
                x, y,    // (x, y) of upper left corner in output window
                GRANNY_IMAGE_WIDTH  , GRANNY_IMAGE_HEIGHT   ,    // Scaled width, height
                window);


    }

}



