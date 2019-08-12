package day16;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		String msg = null;
		msg="xmlsfd";
		try {
			System.out.println(msg.charAt(3));
			int num=Integer.parseInt(msg);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("자원 반납 코드");
		}
		System.out.println("main end");
	}

}
