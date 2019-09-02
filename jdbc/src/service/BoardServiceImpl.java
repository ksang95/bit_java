package service;

import java.util.List;

import dao.BoardDAO;
import vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	BoardDAO dao = null;
	
	public BoardServiceImpl() {}
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		return dao.getBoardRec();
	}

	@Override
	public List<BoardVO> boardList(int page, int n) {
		// TODO Auto-generated method stub
		return dao.getBoardRec(page, n);
	}

	@Override
	public int addBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}

	@Override
	public int deleteBoard(int seq) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(vo);
	}

	@Override
	public List<BoardVO> searchBoard(String word) {
		// TODO Auto-generated method stub
		return dao.searchBoard(word);
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return dao.countBoard();
	}

	@Override
	public List<BoardVO> searchTitle(String title) {
		// TODO Auto-generated method stub
		return dao.searchTitle(title);
	}
	@Override
	public List<BoardVO> searchId(String id) {
		// TODO Auto-generated method stub
		return dao.searchId(id);
	}

}
