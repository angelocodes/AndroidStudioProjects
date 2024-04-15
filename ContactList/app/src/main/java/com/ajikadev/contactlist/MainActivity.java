package com.ajikadev.contactlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> contacts;
    ArrayAdapter<Contact> contactsAdapter;
    ListView listView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        btn = findViewById(R.id.button);

        contacts = new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.ajikadev.contacatapp.SecondActivity");
                startActivityForResult(i, 1);
            }
        });

        // Initialize contactsAdapter after contacts list is populated
        contactsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(contactsAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("NAME_DATA");
            String phone = data.getStringExtra("PHONE_DATA");
            String email = data.getStringExtra("EMAIL_DATA");

            Toast.makeText(getApplicationContext(), "Bikooze: " + name, Toast.LENGTH_SHORT).show();

            // Create a new Contact object and add it to the contacts list
            Contact newContact = new Contact(name, phone, email);
            contacts.add(newContact);

            // Notify the adapter that the data has changed
            contactsAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(getApplicationContext(), "Biganye", Toast.LENGTH_SHORT).show();
        }
    }
}
