package egovframework.example.board.mapper;

import egovframework.example.board.domain.UserVO;

public interface UserMapper {
	public int userIdCheck(UserVO vo);
	
	public int userPwCheck(UserVO vo);

}
