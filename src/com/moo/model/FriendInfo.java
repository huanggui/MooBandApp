package com.moo.model;

import android.widget.ImageView;

public class FriendInfo {
	private ImageView mImageView;
	private String mName;
	private String mTel;
	private String mQQ;
	private String mWeiXin;
	
	public FriendInfo(ImageView img, String name, String tel, String qq, String wx) {
		this.mImageView = img;
		this.mName = name;
		this.mTel = tel;
		this.mQQ = qq;
		this.mWeiXin = wx;
	}
	
	public ImageView getmImageView() {
		return mImageView;
	}
	
	public void setmImageView(ImageView img) {
		this.mImageView = img;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public String getmQQ() {
		return mQQ;
	}

	public void setmQQ(String mQQ) {
		this.mQQ = mQQ;
	}

	public String getmWeiXin() {
		return mWeiXin;
	}

	public void setmWeiXin(String mWeiXin) {
		this.mWeiXin = mWeiXin;
	}
	
	
	
}
