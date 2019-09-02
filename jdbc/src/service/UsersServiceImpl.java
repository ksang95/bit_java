package service;

import java.util.List;

import dao.UsersDAO;
import vo.UsersVO;

public class UsersServiceImpl implements UsersService{

	UsersDAO dao;
	
	public UsersServiceImpl() {}
	public UsersServiceImpl(UsersDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<UsersVO> usersList() {
		// TODO Auto-generated method stub
		return dao.getUserRec();
	}
	@Override
	public List<UsersVO> usersList(int page, int n) {
		// TODO Auto-generated method stub
		return dao.getUserRec(page,n);
	}

	@Override
	public List<UsersVO> login(UsersVO vo) {
		// TODO Auto-generated method stub
		return dao.loginUsers(vo);
	}

	@Override
	public int addUsers(UsersVO vo) {
		// TODO Auto-generated method stub
		return dao.insertUsers(vo);
	}

	@Override
	public int deleteUsers(String id) {
		// TODO Auto-generated method stub
		return dao.deleteUsers(id);
	}

	@Override
	public int updateUsers(UsersVO vo) {
		// TODO Auto-generated method stub
		return dao.updateUsers(vo);
	}

}
