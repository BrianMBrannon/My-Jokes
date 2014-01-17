package com.example.my_jokes;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class JokeListViewAdapter extends ArrayAdapter<String> {

	Context c;
	int textViewResourceId;
	ArrayList<String> data;
	
	public JokeListViewAdapter(Context context, int resource, ArrayList<String> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		
		this.c = context;
		this.textViewResourceId = resource;
		this.data = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater inflator = ((Activity) c).getLayoutInflater();
			convertView = inflator.inflate(textViewResourceId, parent, false);
		}
		
		String item = data.get(position);
		TextView textView = (TextView) convertView.findViewById(R.id.listItemText);
		textView.setText(item);
		textView.setTag(position);  //look up what setTag does exactly
		
		Animation animation = null;
		animation = AnimationUtils.loadAnimation(c, R.anim.pushup);
		animation.reset();
		animation.setDuration(500);
		convertView.startAnimation(animation);
		
		return convertView;
	}
	
	

}
