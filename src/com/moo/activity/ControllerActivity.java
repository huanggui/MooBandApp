package com.moo.activity;

import java.util.ArrayList;
import java.util.List;

import com.moo.R;
import com.moo.adapter.ControllerAdapter;
import com.moo.model.ControllerItemInfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ControllerActivity extends Activity {
	
	private ControllerAdapter mAdapter;
	private List<ControllerItemInfo> mControllerInfos;
	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.controller_tab_layout);
		initData();
		initView();

	}
	
	private void initData() {
		if (mControllerInfos == null) {
			mControllerInfos = new ArrayList<ControllerItemInfo>();
		}
		for (int i = 0; i < 5; i++) {
			ControllerItemInfo info = new ControllerItemInfo("title" + i, "tip" + i);
			if (info != null) {
				mControllerInfos.add(info);
			}
		}
	}
	
	private void initView() {
		mListView = (ListView) findViewById(R.id.list_view);
		mAdapter = new ControllerAdapter(this, mControllerInfos);
		mListView.setAdapter(mAdapter);
	}
	
}
