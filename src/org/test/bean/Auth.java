package org.test.bean;

public class Auth {
      private String  authId;
	  private String  authRange;
	  private String  authMsg;
	
	  
	  public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthRange() {
		return authRange;
	}
	public void setAuthRange(String authRange) {
		this.authRange = authRange;
	}
	public String getAuthMsg() {
		return authMsg;
	}
	public void setAuthMsg(String authMsg) {
		this.authMsg = authMsg;
	}
	@Override
	public String toString() {
		return "Auth [authId=" + authId + ", authRange=" + authRange + ", authMsg=" + authMsg + "]";
	}

	  
	  
}
