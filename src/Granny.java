import javax.swing.*;
import java.awt.*;

public class Granny {
    private Image image;
    private GameView window;

    private final int GRANNY_IMAGE_WIDTH = 533;
    private final int GRANNY_IMAGE_HEIGHT = 543;

    public Granny(GameView window) {
        this.window = window;
        this.image = new ImageIcon("Resources/object/granny.png").getImage();
    }


    public void draw(Graphics g, int x, int y) {

        g.drawImage(image,        // Image to draw
                x, y,    // (x, y) of upper left corner in output window
                GRANNY_IMAGE_WIDTH / 4 , GRANNY_IMAGE_HEIGHT /4  ,    // Scaled width, height
                window);


    }

}






