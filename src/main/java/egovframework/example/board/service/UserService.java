package egovframework.example.board.service;
import java.util.List;

import egovframework.example.board.domain.UserVO;

public interface UserService {
	
	UserVO userLogin(UserVO UserVO);

	int userSignUp(UserVO UserVO);
	
	
	int userEmailCheck(String user_email);
	
	int userPwCheck(String user_password);
	
	
	UserVO findEmailPwSelect(UserVO UserVO);
	
	UserVO userEmailPwCheck(UserVO UserVO);
	
}
