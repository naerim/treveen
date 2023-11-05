package com.ssafy.user.model.service;

import java.util.Map;

import com.ssafy.user.model.User;

public interface UserService {
	int idCheck(String userId) throws Exception;
	User login(Map<String, String> map) throws Exception;
	void join(Map<String, String> map) throws Exception;
	User getUser(String userId) throws Exception;
	void deleteUser(String userId) throws Exception;

	void updateUser(Map<String, String> map) throws Exception;
	void updatePwd(Map<String, String> map) throws Exception;
	int pwdCheck(Map<String, String> map) throws Exception;
}
