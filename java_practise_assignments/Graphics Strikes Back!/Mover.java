import java.awt.Graphics;

interface Mover  {
    void setMovementVector(int xIncrement, int yIncrement);

    void draw(Graphics g);
}
