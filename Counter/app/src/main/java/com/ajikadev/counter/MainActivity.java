package com.ajikadev.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  Button btn;
  int count = 0;
  TextView counter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    counter = findViewById(R.id.textView3); // Correctly initialize the TextView
    btn = findViewById(R.id.button);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    count++;
    counter.setText(String.valueOf(count)); // Correctly convert count to String
  }
}
