package com.moo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moo.R;
import com.moo.adapter.ControllerAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ControllerActivity extends Activity {
	
	private ControllerAdapter mAdapter;
	private List<String> mControllerEvents;
	private List<String> mControllerInfos;
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
			mControllerInfos = new ArrayList<String>();
		}
		if (mControllerEvents == null) {
			mControllerEvents = new ArrayList<String>();
		}
		
		String[] events = getResources().getStringArray(R.array.controller_events);
		String[] beatTitles = getResources().getStringArray(R.array.controller_beat_titles);
		String[] shakeTitles = getResources().getStringArray(R.array.controller_shake_titles);
		List<String[]> listTitles = new ArrayList<String[]>();
		listTitles.add(beatTitles);
		listTitles.add(shakeTitles);
		
		for (int i = 0; i < events.length; i++) {
			mControllerEvents.add(events[i]);
			mControllerInfos.add(events[i]);
			for (int j = 0; j < listTitles.get(i).length; j++) {
				mControllerInfos.add(listTitles.get(i)[j]);
			}
		}
	}
	
	private void initView() {
		mListView = (ListView) findViewById(R.id.list_view);
		mAdapter = new ControllerAdapter(this, mControllerEvents, mControllerInfos);
		mListView.setAdapter(mAdapter);
	}
	
}
