package com.example.saurabh.fireapp;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private EditText mValueField, mKeyValue;
    private FirebaseApp mRef;
    private StorageReference mStorageRef;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStorageRef = FirebaseStorage.getInstance().getReference();

        mKeyValue = (EditText) findViewById(R.id.keyValue);
        mValueField = (EditText) findViewById(R.id.valueField);
        mSendData = (Button) findViewById(R.id.sendData);

        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = mValueField.getText().toString();
                String key = mKeyValue.getText().toString();

                //Write a message to the database
                database = FirebaseDatabase.getInstance();

                //Add simple message to db
//                myRef = database.getReference("message");
//                myRef.child("Name").setValue(value);

                //Database URL
                myRef = database.getReferenceFromUrl("https://fireapp-e8eee.firebaseio.com/Users");

                //Create child key with uniqueID
//                myRef.push().setValue(value);

                myRef.child(key).setValue(value);

                //Create with uniqueID
//                myRef.push().child(key).setValue(value);

                //Or other method to send above value
//                DatabaseReference myChild = myRef.child(key);
//                myChild.setValue(value);

            }
        });
    }
}
