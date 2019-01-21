package egovframework.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.board.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserVO userLogin(UserVO UserVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userSignUp(UserVO UserVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userEmailCheck(String user_email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userPwCheck(String user_password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO findEmailPwSelect(UserVO UserVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO userEmailPwCheck(UserVO UserVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
