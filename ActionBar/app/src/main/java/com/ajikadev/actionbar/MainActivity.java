package com.ajikadev.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Ajika's Bar");
    actionBar.setSubtitle("Angelo");
    actionBar.setIcon(R.drawable.ic_launcher_foreground);

    actionBar.setDisplayUseLogoEnabled(true);
    actionBar.setDisplayShowHomeEnabled(true);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item){
    switch (item.getItemId()){

      case R.id.ajika:
        Toast.makeText(this, "Ajika clicked", Toast.LENGTH_SHORT).show();
        break;
      default:
        Toast.makeText(this, "Oops", Toast.LENGTH_SHORT).show();
    }
    return super.onOptionsItemSelected(item);
  }
}