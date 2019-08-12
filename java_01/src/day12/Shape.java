package day12;

abstract class Shape {
	protected double area;
	private String name;

	public Shape() {
		super();
	}

	public Shape(String name) {
		super();
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void calculationArea();

	public void print() {
		System.out.println(getName() + "의 면적은 " + getArea());
	}
}

class Circle extends Shape {
	private double radius;

	public Circle() {
		super();
	}

	public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void calculationArea() {
		// TODO Auto-generated method stub
		setArea(radius * radius * Math.PI);
	}

}

class Rectangular extends Shape {
	private double width;
	private double height;

	public Rectangular() {
		super();
	}

	public Rectangular(String name, double width, double height) {
		super(name);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void calculationArea() {
		// TODO Auto-generated method stub
		setArea(width * height);
	}

}