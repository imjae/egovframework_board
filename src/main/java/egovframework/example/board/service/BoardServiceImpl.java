package egovframework.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.board.domain.BoardVO;
import egovframework.example.board.domain.Criteria;
import egovframework.example.board.mapper.BoardMapper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	public BoardServiceImpl(){
		
	}
	
	@Override
	public int register(BoardVO board) {
		log.info("register........." + board);
		return mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get.............." + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......" + board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("delete........" + bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List................... " );
		
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri){
		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}
	


}
