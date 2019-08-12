package day15;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item[] i=Item.values();
		for(Item data:i) {
			System.out.println(data);
			System.out.println(data.ordinal());
			System.out.println(data.getVar());
		}
	}

}

enum Item{
	Add(5),Del(11),Search(2),Cancel(22);
	private final int var;
	Item(int v){
		var=v;
	}
	public int getVar() {
		return var;
	}
}