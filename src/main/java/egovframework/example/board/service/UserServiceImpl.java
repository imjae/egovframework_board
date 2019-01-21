package egovframework.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.board.domain.UserVO;
import egovframework.example.board.mapper.UserMapper;
import lombok.Setter;

@Service
public class UserServiceImpl implements UserService {

	
	@Setter(onMethod_ = @Autowired)
	private UserMapper mapper;
	
	
	@Override
	public UserVO userLogin(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userSignUp(UserVO userVO) {
		return mapper.userSignUp(userVO);
	}

	@Override
	public UserVO userEmailCheck(UserVO vo) {
		return mapper.userEmailCheck(vo);
	}

	@Override
	public UserVO userPwCheck(UserVO vo) {
		return mapper.userPwCheck(vo);
	}

	@Override
	public UserVO findEmailPwSelect(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO userEmailPwCheck(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
