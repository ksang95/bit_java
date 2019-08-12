package day14_ex;

public class Rectangle extends Shape implements Resizable{
	double width;
	double height;
	
	public Rectangle() {
		super();
	}
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public void resize(double s) {
		// TODO Auto-generated method stub
		width*=s;
		height*=s;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

}
