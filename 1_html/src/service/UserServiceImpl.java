package service;

import java.util.List;

import dao.UserDAO;
import vo.UserVO;

public class UserServiceImpl implements UserService{

	UserDAO dao;
	
	public UserServiceImpl() {}
	public UserServiceImpl(UserDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<UserVO> usersList() {
		// TODO Auto-generated method stub
		return dao.getUserRec();
	}
	@Override
	public List<UserVO> usersList(int page, int n) {
		// TODO Auto-generated method stub
		return dao.getUserRec(page,n);
	}

	@Override
	public UserVO login(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.loginUsers(vo);
	}

	@Override
	public int addUsers(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.insertUsers(vo);
	}

	@Override
	public int deleteUsers(String id) {
		// TODO Auto-generated method stub
		return dao.deleteUsers(id);
	}

	@Override
	public int updateUsers(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.updateUsers(vo);
	}

}
