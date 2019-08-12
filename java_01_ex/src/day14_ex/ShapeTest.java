package day14_ex;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] sh=new Shape[2];
		sh[0]=new Rectangle(5,6);
		sh[1]=new RectTriangle(6,2);
		for(Shape data:sh) {
			System.out.println("area: "+data.getArea());
			if(data instanceof Resizable) {
				((Resizable) data).resize(0.5);
				System.out.println("new area: "+data.getArea());
			}
		}
	}

}
