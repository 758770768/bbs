package org.test.bean;

public class Reply {
	private String replyId;
	private Integer themeId;
	private String replyBody;
	private String userId;
	private String userName;
	private String replyTime;
	private String userPicture;

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public String getReplyBody() {
		return replyBody;
	}

	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
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

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", themeId=" + themeId + ", replyBody=" + replyBody + ", userId=" + userId
				+ ", userName=" + userName + ", replyTime=" + replyTime + ", userPicture=" + userPicture + "]";
	}

}
