package com.ajikadev.passdata;

import androidx.appcompat.app.AppCompatActivity;


import android.opengl.ETC1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText editText;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       editText = findViewById(R.id.editText);
       btn2 = findViewById(R.id.button2);

       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String enteredData = editText.getText().toString();
               Intent intent = new Intent();
               intent.putExtra("KEY_DATA", enteredData);
               setResult(RESULT_OK, intent);
               finish();
           }
       });

    }
}