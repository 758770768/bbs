package org.test.bean;

public class Moderator {

	private Integer Mid;
	private Integer userId;
	private Integer bclassId;

	public Integer getMid() {
		return Mid;
	}

	public void setMid(Integer mid) {
		Mid = mid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBclassId() {
		return bclassId;
	}

	public void setBclassId(Integer bclassId) {
		this.bclassId = bclassId;
	}

	@Override
	public String toString() {
		return "Moderator [Mid=" + Mid + ", userId=" + userId + ", bclassId=" + bclassId + "]";
	}

}
