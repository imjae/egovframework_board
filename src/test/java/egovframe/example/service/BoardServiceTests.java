package egovframe.example.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.example.board.domain.BoardVO;
import egovframework.example.board.service.BoardService;
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
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	/*@Test
	public void testExist(){
		log.info(service);
		assertNotNull(service);
	}*/
	
	@Test
	public void testRegister(){
		BoardVO board = new BoardVO();
		board.setBoard_title("새로 작성하는eeeee 글 ");
		board.setBoard_content("새로 작성하는 내eeeeeee용");
		board.setBoard_writer("new bieeeeeeeeeeeeeee");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBoard_num());
	}
	
	/*@Test
	public void testGetList(){
		service.getList().forEach(board -> log.info(board));
	}*/
	
	
//	@Test 
//	public void testGet(){
//		log.info(service.get(10L));
//	}
	
	/*@Test
	public void testDelete(){
		log.info("REMOVE RESULT : " + service.remove(5L));
	}*/
	
	/*@Test
	public void testUpdate(){
		BoardVO board = service.get(9L);
		
		if(board == null){
			return;
		}
		
		board.setBoard_title("제목을 수정수ㅅㅈㅅㅈㅅㅈㅅㅈㅅ");
		log.info("MODIFY RESULT : " + service.modify(board));
	}*/
}
