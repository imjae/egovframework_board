package egovframework.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import egovframework.example.board.domain.BoardVO;

public interface BoardMapper {
	//@Select("select * from temp_board where board_num > 0")
	public List<BoardVO> getList();
	
	public int insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long board_num);
	
	public int delete(Long board_num);
	
	public int update(BoardVO board);
}
