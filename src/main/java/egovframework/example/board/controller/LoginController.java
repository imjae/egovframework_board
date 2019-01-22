package egovframework.example.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.board.domain.Criteria;
import egovframework.example.board.domain.UserVO;
import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.UserService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginController {

	@Setter(onMethod_ = @Autowired)
	private UserService userService;
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;

	@RequestMapping(value="/logout.do")
	public ModelAndView logout(HttpServletRequest request, Criteria cri){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		HttpSession session = request.getSession();
		session.removeAttribute("sessionEmail");
		
		modelAndView.addObject("list",boardService.getList(cri));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/loginForm.do")
	public ModelAndView loginForm(){
		ModelAndView modelAndView = new ModelAndView("login/loginForm");
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/loginSuccess.do")
	public ModelAndView loginSuc(HttpServletRequest request, Criteria cri){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");

		HttpSession loginSession;
		loginSession = request.getSession();
		loginSession.setAttribute("sessionEmail", request.getParameter("email"));
		
		modelAndView.addObject("list",boardService.getList(cri));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/user/login.do")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/user/signUpForm.do")
	public ModelAndView signUpForm(){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");

		modelAndView.addObject("index","1");
		modelAndView.addObject("mainPageUrl","../login/signUpForm.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/user/signUp.do", method = RequestMethod.POST)
	public ModelAndView signUp( HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("main/mainPage");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setUser_email(email);
		vo.setUser_password(password);
		
		userService.userSignUp(vo);
	

		modelAndView.addObject("index","1");
		modelAndView.addObject("vo", vo);
		modelAndView.addObject("mainPageUrl","../login/signUpResult.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/userIdCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String userIdCheck(HttpServletRequest request) {

		String id = request.getParameter("id");
		
		UserVO vo = new UserVO();
		vo.setUser_email(id);
		
		
		vo = userService.userEmailCheck(vo);
		int count = 0;
		if(vo == null){
			
		}else{
			count = 1;
		}
		
		return String.valueOf(count);
	}

	@RequestMapping(value = "/user/userPwCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String userPwCheck(HttpServletRequest request) {

		String id = (String) request.getSession().getAttribute("session_id");
		String pw = request.getParameter("pw");

		UserVO vo = new UserVO();
		vo.setUser_email(id);
		vo.setUser_password(pw);

		String result = "";

		UserVO tmp_dto = userService.userEmailPwCheck(vo);

		if (tmp_dto == null) {
			result = "X";
		} else {
			result = "O";
			
	
		}

		return result;
	}

	@RequestMapping(value="/user/userIdPwCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String userIdPwCheck(HttpServletRequest request) {
		String id = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println(id + "," + password + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		UserVO tmp_vo = new UserVO();
		tmp_vo.setUser_email(id);

		UserVO vo = userService.userEmailCheck(tmp_vo);
		
		if(vo == null){
			return "X";
		}else {
			String getPassword = vo.getUser_password()+"";

			if(password.equals(getPassword)){

				return "O";
			}else{
				return "X";
			}
		}
		

	}
	
	
}
