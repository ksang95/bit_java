package service;

import java.util.List;

import vo.UserVO;

public interface UserService {
	List<UserVO> usersList();
	List<UserVO> usersList(int page, int n);
	UserVO login(UserVO vo);
	int addUsers(UserVO vo);
	int deleteUsers(String id);
	int updateUsers(UserVO vo);
	
}
