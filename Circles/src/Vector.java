package circles;

public class Vector {
	private double x;
	private double y;
	
	public Vector(){
		x = 0;
		y = 0;
	}
	
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}

	public Vector(double t){
		x = Math.cos(t);
		y = Math.sin(t);
	}
	
	public void subtract(Vector v){
		x -= v.getX();
		y -= v.getY();
	}
	
	public void multiply(Vector v){
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
		//TODO: Finish this.
		
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
