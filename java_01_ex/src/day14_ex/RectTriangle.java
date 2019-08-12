package day14_ex;

public class RectTriangle extends Shape{
	double width;
	double height;
	
	public RectTriangle() {
		super();
	}
	public RectTriangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height/2;
	}

}
