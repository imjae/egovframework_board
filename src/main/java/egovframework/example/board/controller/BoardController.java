package egovframework.example.board.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.example.board.domain.BoardVO;
import egovframework.example.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardController {
	
	private BoardService service;
	
	public BoardController(){
		
	}
	
	
	@RequestMapping(value="/welcome.do")
	public ModelAndView welcome(){
		ModelAndView modelAndView = new ModelAndView("board/welcome");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list.do")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("board/list");
		
		return modelAndView;
	}
	
	/*
	@RequestMapping(value="/list")
	public void list(Model model){
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
/*
	@RequestMapping(value="/register.do")
	public String register(BoardVO board, RedirectAttributes rttr){
		
		log.info("register : " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBoard_num());
		
		return "rediret:/board/list";
	}
	
	@RequestMapping(value="/modify")
	public String modify(BoardVO board, RedirectAttributes rttr){
		log.info("modify : " + board);
		
		if(service.modify(board)){
			rttr.addFlashAttribute("result" , "success");
					
		}
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/remove")
	public String remove(@RequestParam("board_num") Long board_num, RedirectAttributes rttr){
		log.info("remove.... " + board_num);
		
		if(service.remove(board_num)){
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}*/
	
}
