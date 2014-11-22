package com.moo.activity;

import com.moo.R;
import com.moo.component.BottomTabHost;
import com.moo.component.BottomTabHost.TabSpec;
import com.moo.component.TabView;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

public class MooBandActivity extends BottomTabActivity implements BottomTabHost.OnTabChangeListener{
	
	private static final String TAG = "MooBandActivity";
	private static final int MAX_TAB_COUNT = 4;
	
	// 健康，碰友，体感，身份
	public static enum TabType {
		HEALTH, FRIENDS, CONTROLLER, IDENTITY
	}
	
	static final String TAB_1 = "tab1";
	static final String TAB_2 = "tab2";
	static final String TAB_3 = "tab3";
	static final String TAB_4 = "tab4";
	
	private BottomTabHost mHost;
	private TabView[] mTabBtns = new TabView[MAX_TAB_COUNT];
	private int currIndex = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mHost = getTabHost();
        mHost.setOnTabChangedListener(this);
        initTabs();  
    }
    
    private void initTabs() {

		TypedArray icons = getResources().obtainTypedArray(R.array.tab_icons);
		String[] titles = getResources().getStringArray(R.array.tab_titles);
		
		Resources resource = getResources();
		TabSpec tabSpec = mHost.newTabSpec(TAB_1);
		tabSpec.setIndicator(titles[0], resource.getDrawable(icons.getResourceId(0, 0)), resource.getDrawable(R.drawable.tab_item_bg_selector));
		tabSpec.setContent(new Intent(MooBandActivity.this, HealthActivity.class));
		mTabBtns[0] = (TabView) mHost.addTab(tabSpec,R.id.main_tab1);

		tabSpec = mHost.newTabSpec(TAB_2);
		tabSpec.setIndicator(titles[1], resource.getDrawable(icons.getResourceId(1, 0)), resource.getDrawable(R.drawable.tab_item_bg_selector));
		tabSpec.setContent(new Intent(MooBandActivity.this, FriendsActivity.class));
		mTabBtns[1] = (TabView) mHost.addTab(tabSpec,R.id.main_tab2);

		tabSpec = mHost.newTabSpec(TAB_3);
		tabSpec.setIndicator(titles[2], resource.getDrawable(icons.getResourceId(2, 0)), resource.getDrawable(R.drawable.tab_item_bg_selector));
		tabSpec.setContent(new Intent(MooBandActivity.this, ControllerActivity.class));
		mTabBtns[2] = (TabView) mHost.addTab(tabSpec,R.id.main_tab3);
		
		tabSpec = mHost.newTabSpec(TAB_4);
		tabSpec.setIndicator(titles[3], resource.getDrawable(icons.getResourceId(3, 0)), resource.getDrawable(R.drawable.tab_item_bg_selector));
		tabSpec.setContent(new Intent(MooBandActivity.this, IdentityActivity.class));
		mTabBtns[3] = (TabView) mHost.addTab(tabSpec,R.id.main_tab4);
		
		icons.recycle();
	}
    
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onTabChanged(String tabId, String preTabId) {
		
	}

	public void onTabAction(String tabId, String nextTabId) {
		// TODO Auto-generated method stub
		
	}
}