package com.example.saurabh.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private FirebaseApp mRef;
    private StorageReference mStorageRef;
    public FirebaseDatabase database;
    public DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStorageRef = FirebaseStorage.getInstance().getReference();

        mSendData = (Button) findViewById(R.id.sendData);
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Write a message to the database
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("message");

                myRef.child("users").child("1").setValue("Hello");


//                myRef.setValue("Hello, World!!!!");



            } });
    }
}
