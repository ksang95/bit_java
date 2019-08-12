package day13;

abstract class Shape {
	abstract double area();
}

interface Drawable{
	public abstract void draw();
}

public class Circle extends Shape {
	Point p;
	int r;

	@Override
	double area() {
		// TODO Auto-generated method stub
		return r * r * Math.PI;
	}
}