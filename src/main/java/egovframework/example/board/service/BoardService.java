package egovframework.example.board.service;

import java.util.List;

import egovframework.example.board.domain.BoardVO;
import egovframework.example.board.domain.Criteria;

public interface BoardService {

	public int register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	//public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
}
