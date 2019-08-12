package day15;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Command cmd=new DeleteCommand();
		cmd.exec();
		cmd=new UpdateCommand();
		cmd.exec();
	}

}
