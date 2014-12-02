package com.moo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.moo.R;
import com.moo.component.SwitchButton;
import com.moo.model.ControllerItemInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ControllerAdapter extends BaseAdapter{

	private List<ControllerItemInfo> itemInfos = new ArrayList<ControllerItemInfo>();
	private Context mContext;
	
	
	public ControllerAdapter(Context context, List<ControllerItemInfo> list) {
		mContext = context;
		if (list != null && list.size() > 0) {
			itemInfos.clear();
			itemInfos.addAll(list);
		}
	}

	public int getCount() {
		if (itemInfos == null) {
			return 0;
		}else {
			return itemInfos.size();
		}
	}

	public Object getItem(int position) {
		if (position  < 0 || position >= itemInfos.size()) {
			return null;
		}else {
			return itemInfos.get(position);
		}
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		HolderView holder;
		if (convertView == null) { 			
			holder = new HolderView();
	        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_controller_list, null);  
	        holder.tvTitle =(TextView) convertView.findViewById(R.id.tv_title);  
	        holder.tvTip = (TextView) convertView.findViewById(R.id.tv_tip);
	        holder.switchButton = (SwitchButton) convertView.findViewById(R.id.switchBtn);
	        convertView.setTag(holder);
		}else {
			holder = (HolderView) convertView.getTag();
		}
	
		ControllerItemInfo itemInfo = (ControllerItemInfo) getItem(position);
		if (itemInfo == null) {
			return null;
		}

		holder.tvTitle.setText(itemInfo.getTitleString());
		holder.tvTip.setText(itemInfo.getTipString());
		holder.switchButton.setSwitchState(false);
		
		return convertView;
	}
	
	public class HolderView {
		TextView tvTitle;
		TextView tvTip;
		SwitchButton switchButton;
	}

}
