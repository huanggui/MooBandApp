package com.moo.activity;

import com.moo.R;
import com.moo.utils.BLEDataUtils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HealthActivity extends Activity {
	
	private TextView tvHeartRate;
	private TextView tvTemperature;
	private TextView tvStepNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.health_tab_layout);
		initView();
		initData();
	}
	
	private void initView() {
		tvHeartRate = (TextView) findViewById(R.id.tv_heartbeat);
		tvTemperature = (TextView) findViewById(R.id.tv_temperature);
		tvStepNumber = (TextView) findViewById(R.id.tv_runrecord);
	}
	
	private void initData() {
		tvHeartRate.setText(String.valueOf(BLEDataUtils.getHeartRate()));
		tvTemperature.setText(String.valueOf(BLEDataUtils.getTemperature()));
		tvStepNumber.setText(BLEDataUtils.getStepNumber() + "步");
	}

}
