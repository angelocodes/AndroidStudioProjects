package com.ajikadev.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

      Toast.makeText(this,"Landscape",Toast.LENGTH_SHORT).show();
    }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

      Toast.makeText(this,"Portrait",Toast.LENGTH_SHORT).show();

    }
}}
