package test;

import dao.DeptDao;

public class Test09_DeptDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeptDao dao=new DeptDao();
		
		dao.getAllDeptRec().forEach(i->System.out.println(i));
		System.out.println("----------------------------------------");
		dao.getDeptRec(2, 5).forEach(i->System.out.println(i));
	}

}
