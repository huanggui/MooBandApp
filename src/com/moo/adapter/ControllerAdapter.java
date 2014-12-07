package com.moo.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moo.R;
import com.moo.component.SwitchButton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ControllerAdapter extends BaseAdapter{

	private List<String>  eventList = new ArrayList<String>();
	private List<String>  itemList = new ArrayList<String>();
	private Context mContext;
	
	
	public ControllerAdapter(Context context, List<String> events, List<String> items) {
		mContext = context;
		eventList = events;
		itemList = items;
	}


	public int getCount() {
		if (itemList == null) {
			return 0;
		}else {
			return itemList.size();
		}
	}

	public Object getItem(int position) {
		if (position  < 0 || position >= itemList.size()) {
			return null;
		}else {
			return itemList.get(position);
		}
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
    public boolean isEnabled(int position) {  
        // TODO Auto-generated method stub  
         if(eventList.contains(getItem(position))){  
             return false;  
         }  
         return super.isEnabled(position);  
    } 

	public View getView(int position, View convertView, ViewGroup parent) {
		if(eventList.contains(getItem(position))) {
			return getGroupView(position, convertView, parent);
		}else {
			return getItemView(position, convertView, parent);
		}
	}
	
	private View getGroupView(int position, View convertView, ViewGroup parent) {
		HolderGroupView holder;
		if (convertView == null) {
			holder = new HolderGroupView();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.group_controller_list, null); 
			holder.tvTitle = (TextView) convertView.findViewById(R.id.event_text);
			convertView.setTag(holder);
		}else {
			holder = (HolderGroupView) convertView.getTag();
		}
		holder.tvTitle.setText((CharSequence) getItem(position));
		return convertView;
	}
	
	private View getItemView(int position, View convertView, ViewGroup parent) {
		HolderItemView holder;
		if (convertView == null) {
			holder = new HolderItemView();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_controller_list, null); 
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
	        holder.switchButton = (SwitchButton) convertView.findViewById(R.id.switchBtn);
	        holder.switchButton.setTitlesOfSwitch(mContext.getString(R.string.switch_open_state), mContext.getString(R.string.switch_closed_state));
	        convertView.setTag(holder);
		}else {
			holder = (HolderItemView) convertView.getTag();
		}
		holder.tvTitle.setText((CharSequence) getItem(position));
		holder.switchButton.setSwitchState(false);
		return convertView;
	}
	
	public class HolderGroupView {
		TextView tvTitle;
	}
	public class HolderItemView {
		TextView tvTitle;
		SwitchButton switchButton;
	}

}
