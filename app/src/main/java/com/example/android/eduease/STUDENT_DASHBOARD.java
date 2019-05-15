package com.example.android.eduease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class STUDENT_DASHBOARD extends AppCompatActivity {
String TAG = "STUDENT_DASHBOARD";
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);

        Intent intent = getIntent();
        String subj = intent.getStringExtra("subject");

        database= FirebaseDatabase.getInstance();
        myRef = database.getReference(subj);//subject


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                TeacherDataUpload value = dataSnapshot.getValue(TeacherDataUpload.class);


                Toast.makeText(getApplicationContext(),"teacher is "+value.getName(),Toast.LENGTH_SHORT).show();


                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(),"error in retrieving",Toast.LENGTH_SHORT).show();

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
