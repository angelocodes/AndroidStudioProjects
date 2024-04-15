package com.ajikadev.myactionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ListView listView = findViewById(R.id.listView);
    ArrayList<String> data = new ArrayList<>();
    data.add("Ajika");
    data.add("Angelo");
    CustomAdapter adapter = new CustomAdapter(this, data);
    listView.setAdapter(adapter);
  }
}