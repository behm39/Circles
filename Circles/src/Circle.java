import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Circle {

    private Main main;
    private Vector pos, vel, acc;
    private int r;

    public Circle(Main main) {
        this.main = main;

        Random rand = new Random();

        this.pos = new Vector(rand.nextInt(main.getWidth()),
                rand.nextInt(main.getHeight()));
        this.vel = new Vector();
        this.acc = new Vector();
        this.r = rand.nextInt(25) + 25;
    }

    public void tick() {

        this.vel.add(this.acc);
        this.pos.add(this.vel);

        this.acc.scale(0);

    }

    public void render(Graphics2D g2d) {

        AffineTransform old = g2d.getTransform();

        g2d.translate(this.pos.getX(), this.pos.getY());

        g2d.setColor(Color.WHITE);
        g2d.drawOval(-this.r, -this.r, 2 * this.r, 2 * this.r);

        g2d.setTransform(old);

    }

}
