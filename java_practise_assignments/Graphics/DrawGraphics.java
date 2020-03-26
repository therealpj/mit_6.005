import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.Random;

public class DrawGraphics {
    ArrayList<BouncingBox> boxes;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxes = new ArrayList<BouncingBox>();

        Random random = new Random();

        boxes.add(new BouncingBox(random.nextInt(300), random.nextInt(300), Color.RED));
        boxes.add(new BouncingBox(random.nextInt(300), random.nextInt(300), Color.RED));
        boxes.add(new BouncingBox(random.nextInt(300), random.nextInt(300), Color.RED));

        for(BouncingBox b : boxes) {
            b.setMovementVector(random.nextInt(10), random.nextInt(10));
        }
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        // Background color
        surface.setColor(Color.LIGHT_GRAY);
        surface.fillRect(0, 0, 300, 300);

        // Drawing the outside oval
        surface.setColor(Color.WHITE);
        surface.fillOval(50, 20, 200, 250);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(50, 20, 200, 250);

        // Drawing the (supposed) eyes
        surface.setColor(Color.BLACK);
        surface.fillOval(90, 80, 20, 25);
        surface.fillOval(190, 80, 20, 25);

        // Drawing teeth (?)
        surface.drawRect(100, 200, 100, 20);
        surface.drawLine(120, 200, 120, 220);
        surface.drawLine(140, 200, 140, 220);
        surface.drawLine(160, 200, 160, 220);
        surface.drawLine(180, 200, 180, 220);

        for (BouncingBox b : boxes) {
            b.draw(surface);
        }
    }
}
