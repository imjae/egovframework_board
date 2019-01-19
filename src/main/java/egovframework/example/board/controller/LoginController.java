package egovframework.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginController {

	
	
	@RequestMapping(value="/loginForm.do")
	public ModelAndView loginForm(){
		ModelAndView modelAndView = new ModelAndView("login/loginForm");
		
		return modelAndView;
	}
	
	
}
