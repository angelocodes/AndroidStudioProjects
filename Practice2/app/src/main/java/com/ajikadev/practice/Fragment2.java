package com.ajikadev.practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_2, container, false);
  }
  @Override
 public void onStart() {
   super.onStart();
   //Button view
    Button btn = (Button)getActivity().findViewById(R.id.btn);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        TextView tv1 = (TextView)getActivity().findViewById(R.id.tv1);
        Toast.makeText(getActivity(),tv1.getText(), Toast.LENGTH_SHORT).show();
      }
    });
 }
}