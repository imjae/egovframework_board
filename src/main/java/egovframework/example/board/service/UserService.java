package egovframework.example.board.service;
import java.util.List;

import egovframework.example.board.domain.UserVO;

public interface UserService {
	
	UserVO userLogin(UserVO UserVO);

	int userSignUp(UserVO UserVO);
	
	
	UserVO userEmailCheck(UserVO vo);
	
	UserVO userPwCheck(UserVO vo);
	
	
	UserVO findEmailPwSelect(UserVO UserVO);
	
	UserVO userEmailPwCheck(UserVO UserVO);
	
}
