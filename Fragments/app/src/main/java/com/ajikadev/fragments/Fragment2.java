package com.ajikadev.fragments;

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
    public void onStart(){
        super.onStart();

        Button btnGetText = (Button)getActivity().findViewById(R.id.btnGetText);
        btnGetText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                TextView lbl = (TextView)getActivity().findViewById(R.id.lblFragment1);
                Toast.makeText(getActivity(),lbl.getText(),Toast.LENGTH_SHORT).show();

            }
        });
    }

}