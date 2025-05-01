import javax.swing.*;
import java.awt.*;

public class TheCookie
{
        private Image image;
        private GameView window;

        private final int COOKIE_IMAGE_WIDTH = 533;
        private final int COOKIE_IMAGE_HEIGHT = 543;

        public TheCookie(GameView window) {
            this.window = window;
            this.image = new ImageIcon("Resources/object/cookie.png").getImage();
        }




        public void draw(Graphics g, int x, int y) {

            g.drawImage(image,        // Image to draw
                    x, y,    // (x, y) of upper left corner in output window
                    (int) (COOKIE_IMAGE_WIDTH / 2.2 ), (int)(COOKIE_IMAGE_HEIGHT /2.2 ) ,    // Scaled width, height
                    window);


        }

    }


