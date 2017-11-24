package org.test.bean;

public class Theme {

	 private Integer themeId           ;
	 private Integer  userId           ;
	 private Integer  classId          ;
	 private Integer  themeClassId     ;
	 private String  themeClass       ;
	 private String  themeTitle       ;
	 private String  themeBody        ;
	 private String  themeTime        ;
	 private Integer  themeViewCount   ;
	 private Integer  themeSign        ;
	 private Integer  themeIsTop       ;
	 private String  userName         ;
	 private String  className        ;
	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getThemeClassId() {
		return themeClassId;
	}
	public void setThemeClassId(Integer themeClassId) {
		this.themeClassId = themeClassId;
	}
	public String getThemeClass() {
		return themeClass;
	}
	public void setThemeClass(String themeClass) {
		this.themeClass = themeClass;
	}
	public String getThemeTitle() {
		return themeTitle;
	}
	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}
	public String getThemeBody() {
		return themeBody;
	}
	public void setThemeBody(String themeBody) {
		this.themeBody = themeBody;
	}
	public String getThemeTime() {
		return themeTime;
	}
	public void setThemeTime(String themeTime) {
		this.themeTime = themeTime;
	}
	public Integer getThemeViewCount() {
		return themeViewCount;
	}
	public void setThemeViewCount(Integer themeViewCount) {
		this.themeViewCount = themeViewCount;
	}
	public Integer getThemeSign() {
		return themeSign;
	}
	public void setThemeSign(Integer themeSign) {
		this.themeSign = themeSign;
	}
	public Integer getThemeIsTop() {
		return themeIsTop;
	}
	public void setThemeIsTop(Integer themeIsTop) {
		this.themeIsTop = themeIsTop;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Theme [themeId=" + themeId + ", userId=" + userId + ", classId=" + classId + ", themeClassId="
				+ themeClassId + ", themeClass=" + themeClass + ", themeTitle=" + themeTitle + ", themeBody="
				+ themeBody + ", themeTime=" + themeTime + ", themeViewCount=" + themeViewCount + ", themeSign="
				+ themeSign + ", themeIsTop=" + themeIsTop + ", userName=" + userName + ", className=" + className
				+ "]";
	}
	                      
	
}
