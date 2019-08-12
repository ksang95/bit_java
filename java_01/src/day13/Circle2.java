package day13;

public class Circle2 extends Shape implements Drawable {
	Point p;
	int r;

	public Circle2() {
		p = new Point(0, 0);
	}

	public Circle2(Point p, int r) {
		this.p = p;
		this.r = r;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Circle2 [p=" + p + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
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
		Circle2 other = (Circle2) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}

	@Override
	double area() {
		// TODO Auto-generated method stub
		return  r*r*Math.PI;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + "draw~~~");
	}

}
