package com.ssafy.users.model;

public class Users {
	private int idx;
	private String userId;
	private String userPwd;
	private String userName;
	private String emailId;
	private String emailDomain;
	private String mobile;
	private String salt;
	private String joinDate;
	private String grade;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Users [idx=" + idx + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", emailId=" + emailId + ", emailDomain=" + emailDomain + ", mobile=" + mobile + ", salt=" + salt
				+ ", joinDate=" + joinDate + ", grade=" + grade + "]";
	}
}
