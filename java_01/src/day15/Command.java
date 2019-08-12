package day15;

@FunctionalInterface
public interface Command {
	void exec();
	default public void check() {
		System.out.println("check~~~~");
	}
}

class DeleteCommand implements Command{

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("DeleteCommand 수행");
	}
	
}

class UpdateCommand implements Command{

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("UpdateCommand 수행");
	}
	
}