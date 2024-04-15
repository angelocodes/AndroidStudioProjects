package com.ajikadev.ui_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  Button button2;
  int count = 1;
  TextView counter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    button2 = findViewById(R.id.next);
    button2.setOnClickListener(view -> {
      Intent intent = new Intent(MainActivity.this, MainActivity2.class);
      startActivity(intent);
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    count++;
    counter.findViewById(R.id.textView2);
    counter.setText(count);
  }
}