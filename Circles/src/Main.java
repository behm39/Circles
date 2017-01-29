import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Main extends Canvas implements Runnable {

    public static final String TITLE = "Circles";
    public static final int WIDTH = 640, HEIGHT = 480, NUM_CIRCLES = 10;

    private Thread thread;
    private boolean running;

    ArrayList<Circle> circles;

    public Main() {

        this.thread = new Thread(this);
        this.running = false;

        new Window(this, TITLE, WIDTH, HEIGHT);

        this.circles = new ArrayList<Circle>();
        for (int i = 0; i < NUM_CIRCLES; i++) {
            this.circles.add(new Circle(this));
        }

        this.start();

    }

    public void start() {
        this.thread.start();
        this.running = true;
    }

    public void stop() {
        try {
            this.thread.join();
            this.running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        for (int i = 0; i < this.circles.size(); i++) {
            this.circles.get(i).tick();
        }
    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        g2d.setColor(Color.WHITE);
        for (int i = 0; i < this.circles.size(); i++) {
            this.circles.get(i).render(g2d);
        }

        g2d.dispose();
        bs.show();

    }

    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        int ticks = 0;
        int frames = 0;

        long lastTime = System.nanoTime();
        long now = System.nanoTime();
        double tps = 60;
        double ns = 1000000000 / tps;
        double delta = 0;
        while (this.running) {
            now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                this.tick();
                ticks++;
                delta--;
            }
            this.render();
            frames++;
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames + " TPS: " + ticks);
                timer += 1000;
                frames = 0;
                ticks = 0;
            }
        }

    }

    public static void main(String[] args) {
        new Main();
    }

}
