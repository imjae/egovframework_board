package egovframework.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="firstPage.do")
	public ModelAndView welcome(){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		return modelAndView;
	}
	 

	
	
	@RequestMapping(value="/board/list.do")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("board/list");
		log.info("list");
		modelAndView.addObject("list", service.getList());
		
		return modelAndView;
	}
	

	@RequestMapping(value="/board/register.do", method=RequestMethod.GET)
	public ModelAndView register(BoardVO board){
		
		ModelAndView modelAndView = new ModelAndView("board/list");
		
		board.setBoard_title("test용 제목");
		board.setBoard_writer("test writer");
		board.setBoard_content("test contents ss");
		log.info("register : " + board);
		
		service.register(board);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/board/modify.do")
	public String modify(BoardVO board, RedirectAttributes rttr){
		log.info("modify : " + board);
		
		if(service.modify(board)){
			rttr.addFlashAttribute("result" , "success");
					
		}
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/remove.do")
	public String remove(@RequestParam("board_num") Long board_num, RedirectAttributes rttr){
		log.info("remove.... " + board_num);
		
		if(service.remove(board_num)){
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}

}
