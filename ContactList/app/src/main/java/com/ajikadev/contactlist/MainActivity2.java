package com.ajikadev.contactlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity2 extends Activity {

    EditText nameEditText, emailEditText, phoneEditText;
    Button button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button2 = findViewById(R.id.button2);
        nameEditText = findViewById(R.id.editName);
        emailEditText = findViewById(R.id.editEmail);
        phoneEditText = findViewById(R.id.editTextPhone);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("NAME_DATA", name);
                resultIntent.putExtra("EMAIL_DATA", email);
                resultIntent.putExtra("PHONE_DATA", phone);
                setResult(RESULT_OK, resultIntent);

                finish();
            }
        });
    }
}
