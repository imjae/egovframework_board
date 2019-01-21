package egovframework.example.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.board.domain.UserVO;
import egovframework.example.board.service.UserService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginController {

	@Setter(onMethod_ = @Autowired)
	private UserService userService;

	
	
	@RequestMapping(value="/loginForm.do")
	public ModelAndView loginForm(){
		ModelAndView modelAndView = new ModelAndView("login/loginForm");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/user/signUpForm.do")
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");

		modelAndView.addObject("index","1");
		modelAndView.addObject("mainPageUrl","../login/signUp.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/user/signUpForm.do")
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");

		modelAndView.addObject("index","1");
		modelAndView.addObject("mainPageUrl","../login/signUp.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/userIdCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String userIdCheck(HttpServletRequest request) {

		String id = request.getParameter("id");
		int count = userService.userEmailCheck(id);

		return String.valueOf(count);
	}

	@RequestMapping(value = "/user/userPwCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String userPwCheck(HttpServletRequest request) {

		String id = (String) request.getSession().getAttribute("session_id");
		String pw = request.getParameter("pw");

		UserVO vo = new UserVO();
		vo.setEmail(id);
		vo.setPassword(pw);

		String result = "";

		UserVO tmp_dto = userService.userEmailPwCheck(vo);

		if (tmp_dto == null) {
			result = "X";
		} else {
			result = "O";
		}

		return result;
	}

	@RequestMapping(value = "/user/userIdPwCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String userIdPwCheck(HttpServletRequest request) {

		String id = request.getParameter("id");
		String password = request.getParameter("pw");

		System.out.println(id + "," + password);

		int email_count = userService.userEmailCheck(id);
		int pw_count = userService.userPwCheck(password);

		int qwert = email_count + pw_count;
		System.out.println(qwert);

		String result = "";

		if (qwert >= 2) {
			result = "O";
		} else {
			result = "X";
		}

		return result;
	}
	
	
}
