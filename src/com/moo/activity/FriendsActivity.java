package com.moo.activity;

import java.util.ArrayList;
import java.util.List;

import com.moo.R;
import com.moo.adapter.FriendsAdapter;
import com.moo.model.FriendInfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FriendsActivity extends Activity {
	
	private FriendsAdapter mAdapter;
	private List<FriendInfo> mFriendInfos;
	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_tab_layout);
		initData();
		initView();

	}
	
	private void initData() {
		if (mFriendInfos == null) {
			mFriendInfos = new ArrayList<FriendInfo>();
		}
		for (int i = 0; i < 7; i++) {
			FriendInfo info = new FriendInfo(null, "name" + i, "tel" + i, "qq" + i, "wx" + i);
			if (info != null) {
				mFriendInfos.add(info);
			}
		}
	}
	
	private void initView() {
		mListView = (ListView) findViewById(R.id.list_view);
		mAdapter = new FriendsAdapter(this, mFriendInfos);
		mListView.setAdapter(mAdapter);
	}
	
}
