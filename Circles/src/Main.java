import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

@SuppressWarnings("serial")
public class Main extends Canvas implements Runnable {

    public static final String TITLE = "Circles";
    public static final int WIDTH = 640, HEIGHT = 480;

    private Thread thread;
    private boolean running;

    public Main() {

        this.thread = new Thread(this);
        this.running = false;

        new Window(this, TITLE, WIDTH, HEIGHT);

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
