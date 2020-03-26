import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Mover> movers;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        movers = new ArrayList<Mover>();

        Rectangle box1 = new Rectangle(15, 20, Color.RED);
        Oval oval1 = new Oval(20, 20 ,Color.RED);
        movers.add(new Bouncer(100, 170, box1));
        movers.add(new Bouncer(200, 0, oval1));


        Rectangle box2 = new Rectangle(15, 20, Color.BLUE);
        Oval oval2 = new Oval(20, 20, Color.BLUE);
        movers.add(new StraightMover(170, 100, box2));
        movers.add(new StraightMover(0, 200, oval2));

        for (Mover b : movers) {
            b.setMovementVector(3, 1);
        }
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {

        for(Mover s : movers) {
            s.draw(surface);
        }
    }
}
