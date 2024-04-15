package com.ajikadev.fragmentsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  TextView display;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fragment1 fragment1 = (fragment1) getSupportFragmentManager().findFragmentById(R.id.fragement1);
    display = fragment1.getView().findViewById(R.id.txt_display);
  }

  public void onClick(View v) {
    Button button = v.findViewById(v.getId());
    String text = button.getText().toString();
    text =display.getText().toString().concat(text);
    display.setText(text);
  }
}