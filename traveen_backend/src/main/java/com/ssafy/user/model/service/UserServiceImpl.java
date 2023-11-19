package com.ssafy.user.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.User;
import com.ssafy.user.model.mapper.UserMapper;
import com.ssafy.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	private UserUtil userUtil = new UserUtil();

	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public User login(User user) throws Exception {
		String userId = user.getUserId();
		String userPwd = user.getUserPwd();
		
		String salt = userMapper.getUserById(userId).getSalt();
		if (salt == null) {
			return null;
		}
		
		user.setUserPwd(userUtil.getEncrypt(userPwd, salt));
		
		return userMapper.login(user);
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return userMapper.idCheck(userId);
	}

	@Override
	public void join(User user) throws Exception {
		String salt = userUtil.getSalt();
		user.setSalt(salt);
		user.setUserPwd(userUtil.getEncrypt(user.getUserPwd(), salt));
		userMapper.join(user);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		userMapper.deleteUser(userId);
	}

	@Override
	public User getUserById(String userId) throws Exception {
		return userMapper.getUserById(userId);
	}

	@Override
	public User getUserByEmail(String emailId, String emailDomain) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("emailId", emailId);
		map.put("emailDomain", emailDomain);
		return userMapper.getUserByEmail(map);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userMapper.updateUser(user);
	}

	@Override
	public void updatePwd(User user, String newPwd) throws Exception {
		String salt = userUtil.getSalt();
		newPwd = userUtil.getEncrypt(newPwd, salt);
		user.setUserPwd(newPwd);
		user.setSalt(salt);
		userMapper.updatePwd(user, newPwd);
	}

	@Override
	public int pwdCheck(String userId, String userPwd) throws Exception {
		User user = userMapper.getUserById(userId);
		String salt = user.getSalt();
		userPwd = userUtil.getEncrypt(userPwd, salt);
		return userMapper.pwdCheck(userId, userPwd);
	}
	
	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("refreshToken", refreshToken);
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return userMapper.getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		userMapper.deleteRefreshToken(map);
	}
}