package service;

import java.util.List;

import vo.BoardVO;

public interface BoardService {

	public List<BoardVO> boardList();
	public List<BoardVO> boardList(int page, int n);
	public int addBoard(BoardVO vo);
	public int deleteBoard(int seq);
	public int updateBoard(BoardVO vo);
	public List<BoardVO> searchBoard(String word);
	public int countBoard();
	public List<BoardVO> searchTitle(String title);
	public List<BoardVO> searchId(String id);
}
