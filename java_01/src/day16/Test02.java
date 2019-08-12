package day16;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");
		String msg = null;
		msg="xmlsfd";
		try {
			System.out.println(msg.charAt(3));
			int num=Integer.parseInt(msg);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("자원 반납 코드");
		}
		System.out.println("main end");
	}

}
