package com.ajikadev.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends Activity {
  Button btn;
  EditText et_name;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    btn = findViewById(R.id.button2);
    et_name = findViewById(R.id.name_et);


    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String name = et_name.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("NAME", name);
        setResult(RESULT_OK, resultIntent);
        finish();

      }
    });

  }
}