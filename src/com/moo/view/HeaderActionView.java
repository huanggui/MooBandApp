package com.moo.view;

import com.moo.R;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeaderActionView extends LinearLayout{
	
	private Context mContext;
	private TextView mTitle;
	private Button mRightBtn;
	
	public HeaderActionView(Context context) {
		super(context);
		mContext = context;
		initView();
	}

	public HeaderActionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		initView();
	}
	
	private void initView() {
		LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.header_action_view, this, true);
		
		mTitle = (TextView) findViewById(R.id.tv_title);
		mRightBtn = (Button) findViewById(R.id.btn_right);
	}
	
	public void setTitle(String title) {
		if (TextUtils.isEmpty(title)) {
			mTitle.setText(R.string.defalut_title);
		}else {
			mTitle.setText(title);
		}
		
	}

}
