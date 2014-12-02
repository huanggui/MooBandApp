package com.moo.model;

public class ControllerItemInfo {
	private String titleString;
	private String tipString;
	
	public ControllerItemInfo(String title, String tip) {
		this.titleString = title;
		this.tipString = tip;
	}

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public String getTipString() {
		return tipString;
	}

	public void setTipString(String tipString) {
		this.tipString = tipString;
	}
	
	
	
}
