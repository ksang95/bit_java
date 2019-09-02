package ex_0827;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BoardDAO;
import service.BoardService;
import service.BoardServiceImpl;
import vo.BoardVO;

public class Ex_BoardService {

	BoardService service = null;

	@Before
	public void setUp() {
		System.out.println("****setUp****");
		BoardDAO dao = new BoardDAO();
		service = new BoardServiceImpl(dao);
	}

	@After
	public void tearDown() {
		service = null;
		System.out.println("****tearDown****");
	}

	/*
	 * public List<BoardVO> boardList(); public List<BoardVO> boardList(int page,
	 * int n); public int addBoard(BoardVO vo); public int deleteBoard(int seq);
	 * public int updateBoard(BoardVO vo); public List<BoardVO> searchTitle(String
	 * title);
	 */
	// @Test
	public void list() {
		service.boardList().forEach(i -> System.out.println(i));
	}

	//@Test
	public void list2() {
		service.boardList(3, 10).forEach(i -> System.out.println(i));
	}

	//@Test
	public void add() {
		BoardVO vo = new BoardVO();
		vo.setTitle("크으");
		vo.setContent("끝나자");
		vo.setId("sql");
		int result = 0;
		result = service.addBoard(vo);
		System.out.println(result + "개의 글 등록");
	}

	// @Test
	public void delete() {
		int result = 0;
		result = service.deleteBoard(20);
		System.out.println(result + "개의 글 삭제");
	}

	// @Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setTitle("블라블라");
		vo.setContent("dfafefaetawet");
		vo.setSeq(21);
		int result = 0;
		result = service.updateBoard(vo);
		System.out.println(result + "개의 글 수정");
	}
	
	//@Test
	public void searchBoard() {
		service.searchBoard("a").forEach(i->System.out.println(i));
	}
	
	@Test
	public void countBoard() {
		int result = 0;
		result = service.countBoard();
		System.out.println(result+"개의 글");
	}
	
	// @Test
	public void searchTitle() {
		service.searchTitle("A").forEach(i -> System.out.println(i));
	}

	//@Test
	public void searchId() {
		service.searchId("db").forEach(i -> System.out.println(i));
	}

}
