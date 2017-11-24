package org.test.bean;

public class Bclass {

	private Integer classId;
	private String className;
	private String classMsg;
	private String moderatorName;
	private Integer moderatorId;
	private String themeCount;
	private Integer signCount;
	private String noReplyCount;
	private String classPicture;

	@Override
	public String toString() {
		return "Bclass [classId=" + classId + ", className=" + className + ", classMsg=" + classMsg + ", moderatorName="
				+ moderatorName + ", moderatorId=" + moderatorId + ", themeCount=" + themeCount + ", signCount="
				+ signCount + ", noReplyCount=" + noReplyCount + ", classPicture=" + classPicture + "]";
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassMsg() {
		return classMsg;
	}

	public void setClassMsg(String classMsg) {
		this.classMsg = classMsg;
	}

	public String getModeratorName() {
		return moderatorName;
	}

	public void setModeratorName(String moderatorName) {
		this.moderatorName = moderatorName;
	}

	public Integer getModeratorId() {
		return moderatorId;
	}

	public void setModeratorId(Integer moderatorId) {
		this.moderatorId = moderatorId;
	}

	public String getThemeCount() {
		return themeCount;
	}

	public void setThemeCount(String themeCount) {
		this.themeCount = themeCount;
	}

	public Integer getSignCount() {
		return signCount;
	}

	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}

	public String getNoReplyCount() {
		return noReplyCount;
	}

	public void setNoReplyCount(String noReplyCount) {
		this.noReplyCount = noReplyCount;
	}

	public String getClassPicture() {
		return classPicture;
	}

	public void setClassPicture(String classPicture) {
		this.classPicture = classPicture;
	}

}
