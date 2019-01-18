package egovframe.example.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.example.board.domain.BoardVO;
import egovframework.example.board.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"file:src/main/webapp/WEB-INF/config/springmvc/context-datasource.xml",
				"file:src/main/webapp/WEB-INF/config/springmvc/context-servlet.xml"
				}
		)
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	/*@Test
	public void testInsert(){
		BoardVO board = new BoardVO();
		board.setBoard_title("새로 작성하asdasd는 글");
		board.setBoard_content("새로 작asdasd성하는 내용");
		board.setBoard_writer("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}*/
	
	@Test
	public void testGetList(){
		mapper.getList().forEach(board->log.info(board));
	}
	
	/*@Test
	public void testRead(){
		BoardVO board = mapper.read(9L);
		log.info(board);
	}*/
	/*
	@Test
	public void testDelete(){
		log.info("DELETE COUNT : " + mapper.delete(3L));
	}
	*/
	
	/*@Test
	public void testUpdate(){
		BoardVO board = new BoardVO();
		
		board.setBoard_num(10L);
		board.setBoard_title("수정된 ssssssssss제목");
		board.setBoard_content("수정된 내용");
		board.setBoard_writer("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}*/
	
}
