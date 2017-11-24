package org.test.bean;

public class User {

	private String userId;
	private String userName;
	private String userPwd;
	private String userPassQ;
	private String userPassA;
	private String userSex;
	private String userBirth;
	private String userClass;
	private String userExp;
	private String userMoney;
	private String userSpe;
	private String userRegTime;
	private String userLastTime;
	private String authRange;
	private String userPicture;
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPassQ() {
		return userPassQ;
	}

	public void setUserPassQ(String userPassQ) {
		this.userPassQ = userPassQ;
	}

	public String getUserPassA() {
		return userPassA;
	}

	public void setUserPassA(String userPassA) {
		this.userPassA = userPassA;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public String getUserExp() {
		return userExp;
	}

	public void setUserExp(String userExp) {
		this.userExp = userExp;
	}

	public String getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(String userMoney) {
		this.userMoney = userMoney;
	}

	public String getUserSpe() {
		return userSpe;
	}

	public void setUserSpe(String userSpe) {
		this.userSpe = userSpe;
	}

	public String getUserRegTime() {
		return userRegTime;
	}

	public void setUserRegTime(String userRegTime) {
		this.userRegTime = userRegTime;
	}

	public String getUserLastTime() {
		return userLastTime;
	}

	public void setUserLastTime(String userLastTime) {
		this.userLastTime = userLastTime;
	}

	public String getAuthRange() {
		return authRange;
	}

	public void setAuthRange(String authRange) {
		this.authRange = authRange;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userPassQ=" + userPassQ
				+ ", userPassA=" + userPassA + ", userSex=" + userSex + ", userBirth=" + userBirth + ", userClass="
				+ userClass + ", userExp=" + userExp + ", userMoney=" + userMoney + ", userSpe=" + userSpe
				+ ", userRegTime=" + userRegTime + ", userLastTime=" + userLastTime + ", authRange=" + authRange
				+ ", userPicture=" + userPicture + "]";
	}

}
