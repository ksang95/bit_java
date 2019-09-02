package service;

import java.util.List;

import vo.UsersVO;

public interface UsersService {
	public List<UsersVO> usersList();
	public List<UsersVO> usersList(int page, int n);
	public List<UsersVO> login(UsersVO vo);
	public int addUsers(UsersVO vo);
	public int deleteUsers(String id);
	public int updateUsers(UsersVO vo);
	
}
