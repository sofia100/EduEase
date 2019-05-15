package com.example.android.eduease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class STUDENT_DASHBOARD extends AppCompatActivity {
String TAG = "STUDENT_DASHBOARD";
    FirebaseDatabase database;
    DatabaseReference myRef;
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);

        Intent intent = getIntent();
        String subj = intent.getStringExtra("subject");

        database= FirebaseDatabase.getInstance();
        myRef = database.getReference(subj);//subject

        listView = (ListView) findViewById(R.id.list);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
               // TeacherDataUpload value = dataSnapshot.getValue(TeacherDataUpload.class);

                collectNames((Map<String,TeacherDataUpload>) dataSnapshot.getValue());

              //  Toast.makeText(getApplicationContext(),"teacher is "+value.getName(),Toast.LENGTH_SHORT).show();


               // Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(),"error in retrieving",Toast.LENGTH_SHORT).show();

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    private void collectNames(Map<String,TeacherDataUpload> users) {
/*
        ArrayList<String> names = new ArrayList<>();

        ArrayList<String> timeTo = new ArrayList<>();

        ArrayList<String> timeFrom = new ArrayList<>();*/

ArrayList<TeacherDataRetrieve> obj = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, TeacherDataUpload> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            obj.add( new TeacherDataRetrieve( singleUser.get("name").toString(),
                    singleUser.get("timeTo").toString(),
                    singleUser.get("timeFRom").toString()));


          /*  names.add((String) singleUser.get("name"));
            timeFrom.add((String) singleUser.get("timeFRom"));
            timeTo.add((String) singleUser.get("timeTo"));
      */  }
      /* Toast.makeText(getApplicationContext(),"teacher is "+names.toString(),Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),"FROM TIME  is "+timeFrom.toString(),Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),"TO TIME is "+timeTo.toString(),Toast.LENGTH_SHORT).show();
*/
       /* List<String> combined = new ArrayList<String>();
        combined.addAll(names);
        combined.addAll(timeFrom);
        combined.addAll(timeTo);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item,combined);

        listView.setAdapter(adapter);
*/


      /*  ArrayAdapter adapterTotime = new ArrayAdapter<String>(this, R.layout.list_item,timeTo);
        ArrayAdapter adapterFrmtym = new ArrayAdapter<String>(this, R.layout.list_item,timeFrom);
        ArrayAdapter adapterNames = new ArrayAdapter<String>(this, R.layout.list_item,names);

        listTotime.setAdapter(adapterTotime);
        listFromtime.setAdapter(adapterFrmtym);
        listName.setAdapter(adapterNames);
*/

        // System.out.println(names.toString());
        objAdapter adapter = new objAdapter(getApplicationContext(), obj);

        listView.setAdapter(adapter);


    }
}
