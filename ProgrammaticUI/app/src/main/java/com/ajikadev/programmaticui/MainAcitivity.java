package com.ajikadev.programmaticui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainAcitivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(
      ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT
    );
    LinearLayout layout = new LinearLayout(this);
    layout.setOrientation(LinearLayout.VERTICAL);
    TextView tv = new TextView(this);
    tv.setText("This is programmatic UI");
    tv.setLayoutParams(params);
    Button btn = new Button(this);
    btn.setText("Click me");
    btn.setLayoutParams(params);
    layout.addView(tv);
    layout.addView(btn);
    LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(
      LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
      LinearLayoutCompat.LayoutParams.WRAP_CONTENT
    );
    this.addContentView(layout, layoutParams);
  }
}