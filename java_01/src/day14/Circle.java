package day14;

abstract class Shape implements MoveAndDraw{
	abstract double area(); 
}

interface Drawable{
	public abstract void draw() ;
}

interface Moveable{
	void move(int m); 
}

interface MoveAndDraw extends Drawable,Moveable{}

public class Circle extends Shape {
	Point p;
	
	int r;
	
	public Circle() {}
	public Circle(Point p, int r) {
		super();
		this.p = p;
		this.r = r;
	}

	@Override
	public double area() {
		return r*r*Math.PI;
	}

	@Override
	public void draw() {
       System.out.println(getClass().getName()+" 그리기");		
	}
	@Override
	public String toString() {
		return "Circle [p=" + p + ", r=" + r + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + r;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (r != other.r)
			return false;
		return true;
	}
	@Override
	public void move(int m) {
		//p.x = p.x+m;
		p.setX(p.getX()+m);
		p.setY(p.getY()+m);
	}
	
}








