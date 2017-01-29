
public class Vector {
    private double x;
    private double y;

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(double t) {
        this.x = Math.cos(t);
        this.y = Math.sin(t);
    }

    public double getDistance(Vector v) {

        double deltaX = this.x - v.getX();
        double deltaY = this.y - v.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);

    }

    public void subtract(Vector v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public void add(Vector v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public void scale(double s) {
        this.x *= s;
        this.y *= s;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setMag(double m) {
        double theta = this.getTheta();
        this.x = Math.cos(theta);
        this.y = Math.sin(theta);
        this.scale(m);
    }

    public void setTheta(double t) {
        double mag = this.getMag();
        this.x = Math.cos(t);
        this.y = Math.sin(t);
        this.setMag(mag);
    }

    public double getTheta() {
        return Math.atan(this.y / this.x);
    }

    public double getMag() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
