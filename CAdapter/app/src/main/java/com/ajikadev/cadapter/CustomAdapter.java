package com.ajikadev.cadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
  private ArrayList<String> mData;
  private LayoutInflater mInflater;
  public CustomAdapter (Context context, ArrayList<String> data){
    mData = data;
    mInflater = LayoutInflater.from(context);
  }
  @Override
  public int getCount() {
    return mData.size();
  }

  @Override
  public Object getItem(int position) {
    return mData.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if(convertView==null){
      convertView=mInflater.inflate(R.layout.list_item_layout, parent, false);
    }
    TextView textView = convertView.findViewById(R.id.textView);
    textView.setText(mData.get(position));
    return convertView;
  }
}

