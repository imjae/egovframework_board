package egovframework.example.board.mapper;

import egovframework.example.board.domain.UserVO;

public interface UserMapper {
	public UserVO userEmailCheck(UserVO vo);
	
	public UserVO userPwCheck(UserVO vo);
	
	public int userSignUp(UserVO vo);

}
