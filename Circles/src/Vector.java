package circles;

public class Vectors {
	private double x;
	private double y;
	
	public Vectors(){
		x = 0;
		y = 0;
	}
	
	public Vectors(double x, double y){
		x = this.x;
		y = this.y;
	}

	public Vectors(double t){
		x = Math.cos(t);
		y = Math.sin(t);
	}
	
	public void subtract(Vectors v){
		x -= v.getX();
		y -= v.getY();
	}
	
	public void multiply(Vectors v){
		x += v.getX();
		y += v.getY();
	}
	
	public void scale(double s){
		x *= s;
		y *= s;
	}
	
	public void setX(double x){
		x = this.x;
	}
	
	public void setY(double y){
		y = this.y;
	}
	
	public void setMag(double m){
		double t = Math.atan(y/x);
		
	}
	
	public double getMag(){
		return Math.sqrt(x*x + y*y);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
}
