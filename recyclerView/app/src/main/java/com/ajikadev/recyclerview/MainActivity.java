package com.ajikadev.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;
  Adapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    // Convert your startingNames to Person objects
    List<Person> people = new ArrayList<>();
    people.add(new Person("Anirwoth", "Rachel"));
    people.add(new Person("Emesu", "Alfred"));
    people.add(new Person("Nyanzi", "Muniir"));

    adapter = new Adapter(people);
    recyclerView.setAdapter(adapter);
  }
}
