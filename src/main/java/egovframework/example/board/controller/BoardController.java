package egovframework.example.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.example.board.domain.BoardVO;
import egovframework.example.board.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	public BoardController(){
		
	}
	
	@RequestMapping(value="/firstPage.do")
	public ModelAndView welcome(){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");

		modelAndView.addObject("list", service.getList());
		return modelAndView;
	}

	
	
	@RequestMapping(value="/board/list.do")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		log.info("list");
		modelAndView.addObject("list", service.getList());
		modelAndView.addObject("index","1");
		modelAndView.addObject("mainPageUrl","../board/list.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/board/registerForm.do", method=RequestMethod.GET)
	public ModelAndView registerForm(BoardVO board){
		
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		modelAndView.addObject("index","1");
		modelAndView.addObject("mainPageUrl","../board/registerForm.jsp");
		return modelAndView;
	}
	

	@RequestMapping(value="/board/register.do", method=RequestMethod.POST)
	public ModelAndView register(BoardVO board, HttpServletRequest request){

		HttpSession session = request.getSession();
		
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		System.out.println(board.getBoard_title());
		System.out.println(board.getBoard_content());
		log.info("register : " + board);
		
		board.setBoard_writer(String.valueOf(session.getAttribute("sessionEmail")));
		
		int num = service.register(board);

		modelAndView.addObject("index","1");
		modelAndView.addObject("checkNum", num);
		modelAndView.addObject("mainPageUrl","../board/registerResult.jsp");
		return modelAndView;
	}
	

	@RequestMapping(value="/board/remove.do")
	public ModelAndView remove(@RequestParam("bn") Long board_num){
		log.info("remove.... " + board_num);
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		

		modelAndView.addObject("index","1");
		modelAndView.addObject("removeCheck",service.remove(board_num));
		modelAndView.addObject("mainPageUrl","../board/removeResult.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/board/read.do")
	public ModelAndView readForm(HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		long board_num = Long.parseLong(request.getParameter("bn"));
		
		BoardVO vo = service.get(board_num);

		modelAndView.addObject("index","1");
		modelAndView.addObject("boardVO", vo);
		modelAndView.addObject("mainPageUrl","../board/readForm.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/board/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		long board_num = Long.parseLong(request.getParameter("bn"));
		
		BoardVO vo = service.get(board_num);

		modelAndView.addObject("index","1");
		modelAndView.addObject("boardVO", vo);
		modelAndView.addObject("mainPageUrl","../board/modifyForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/board/modify.do")
	public ModelAndView modify(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		long board_num = Long.parseLong(request.getParameter("bn"));
		
		BoardVO vo = service.get(board_num);
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		vo.setBoard_title(board_title);
		vo.setBoard_content(board_content);
		
		boolean modifyStatus = service.modify(vo);

		modelAndView.addObject("index","1");
		modelAndView.addObject("modifyStatus", modifyStatus);
		modelAndView.addObject("mainPageUrl","../board/modifyResult.jsp");
		
		return modelAndView;
	}
	

}
