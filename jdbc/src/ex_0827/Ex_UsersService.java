package ex_0827;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.UsersDAO;
import service.UsersService;
import service.UsersServiceImpl;
import vo.UsersVO;

public class Ex_UsersService {

	UsersService service=null;
	
	@Before
	public void setUp() {
		System.out.println("****setUp****");
		UsersDAO dao=new UsersDAO();
		service=new UsersServiceImpl(dao);
	}
	
	@After
	public void tearDown() {
		service=null;
		System.out.println("****tearDown****");
	}
	
	//@Test
	public void list() {
		service.usersList().forEach(i->System.out.println(i));
	}
	
	@Test
	public void list2() {
		service.usersList(1,10).forEach(i->System.out.println(i));
	}
	
	//@Test
	public void login() {
		UsersVO vo=new UsersVO();
		vo.setId("sql");
		vo.setPassword("8888");
		service.login(vo).forEach(i->System.out.println(i));
	}
	
	//@Test
	public void add() {
		UsersVO vo=new UsersVO();
		vo.setId("pop");
		vo.setPassword("0258");
		vo.setName("김김김");
		vo.setRole("user");
		int result=0;
		result=service.addUsers(vo);
		System.out.println(result+"개 추가");
	}
	
	//@Test
	public void delete() {
		int result=0;
		result=service.deleteUsers("pop");
		System.out.println(result+"개 삭제");
	}
	
	//@Test
	public void update() {
		UsersVO vo=new UsersVO();
		vo.setId("pop");
		vo.setPassword("8989");
		vo.setName("박박박");
		vo.setRole("user");
		int result=0;
		result=service.updateUsers(vo);
		System.out.println(result+"개 수정");
	}

}
