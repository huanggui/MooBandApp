package com.moo.activity;

import java.util.ArrayList;
import java.util.List;
import com.moo.R;
import com.moo.adapter.ControllerAdapter;
import com.moo.utils.DataSetUtils;
import com.moo.utils.DoHardwareUtils;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ControllerActivity extends Activity {
	
	private ControllerAdapter mAdapter;
	private List<String> mControllerEvents;
	private List<String> mControllerInfos;
	private ListView mListView;
	
	private Button beatBtn;
	private Button shakeBtn;
	private Camera camera;
	
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
		beatBtn = (Button) findViewById(R.id.beatBtn);
		beatBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(camera == null) {
					camera = DoHardwareUtils.getCameraInstance();
				}
				if (DataSetUtils.getData(DataSetUtils.OPEN_LIGHT_EVENT)) {
					DoHardwareUtils.openCameraLight(camera);
				}
			}
		});
		
		shakeBtn = (Button) findViewById(R.id.shakeBtn);
		shakeBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (camera == null) {
					return ;
				}
				DoHardwareUtils.closeCameraLight(camera);
			}
		});
	}
	
}
