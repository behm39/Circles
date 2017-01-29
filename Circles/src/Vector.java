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
	
	public void add(Vector v){
		x += v.getX();
		y += v.getY();
	}
	
	public void scale(double s){
		x *= s;
		y *= s;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setMag(double m){
		double theta = this.getTheta();
		this.x = Math.cos(theta);
		this.y = Math.sin(theta);
		this.scale(m);
	}
	
	public void setTheta(double t){
		double mag = this.getMag();
		x = Math.cos(t);
		y = Math.sin(t);
		this.setMag(mag);
	}
	
	public double getTheta(){
		return Math.atan(y/x);
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
