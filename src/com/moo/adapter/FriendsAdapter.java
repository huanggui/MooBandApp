package com.moo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.moo.R;
import com.moo.model.FriendInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendsAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<FriendInfo> mFriends = new ArrayList<FriendInfo>();

	public FriendsAdapter(Context context, List<FriendInfo> list) {
		mContext = context;
		if (list != null && list.size() > 0) {
			mFriends.clear();
			mFriends.addAll(list);
		}
	}
	public int getCount() {
		if (mFriends == null) {
			return 0;
		}else {
			return mFriends.size();
		}
	}

	public Object getItem(int position) {
		if (position < 0 || position > mFriends.size()) {
			return null;
		}else {
			return mFriends.get(position);
		}
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		HolderView holder;
		if (convertView == null) { 			
			holder = new HolderView();
	        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_friends_list, null);  
	        holder.preImage = (ImageView) convertView.findViewById(R.id.pre_image);  
	        holder.tvName =(TextView) convertView.findViewById(R.id.tv_name);  
	        holder.tvTel = (TextView) convertView.findViewById(R.id.tv_tel);
	        holder.tvQQ = (TextView) convertView.findViewById(R.id.tv_qq);
	        holder.tvWeiXin = (TextView) convertView.findViewById(R.id.tv_wx);
	        convertView.setTag(holder);
		}else {
			holder = (HolderView) convertView.getTag();
		}
	
		FriendInfo itemInfo = (FriendInfo) getItem(position);
		holder.preImage = itemInfo.getmImageView();
		holder.tvName.setText(itemInfo.getmName());
		holder.tvTel.setText(itemInfo.getmTel());
		holder.tvQQ.setText(itemInfo.getmQQ());
		holder.tvWeiXin.setText(itemInfo.getmWeiXin());
		
		return convertView;
				
	}
	
	public class HolderView{
		ImageView preImage;
		TextView tvName;
		TextView tvTel;
		TextView tvQQ;
		TextView tvWeiXin;
	}

}
