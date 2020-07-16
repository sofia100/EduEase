package com.example.android.eduease;
//as displayed to the student with ask button

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class TeacherDetail extends AppCompatActivity {
TextView toTime,fromTime,name,cllg;
Button ask;
DatabaseReference dbref,myRef;
String path;
StudentDataUpload stuupload;
String stuEmail;
MeetingObj meetingObj;
   String stuName="null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        toTime=findViewById(R.id.time_to);//chk if correct connction else chng the ids
        fromTime= findViewById(R.id.time_from);
        name=findViewById(R.id.name);
        cllg=findViewById(R.id.cllg);
        ask=findViewById(R.id.ask);

meetingObj=new MeetingObj();

       stuEmail= getIntent().getStringExtra("StudentEmail");
        myRef =  FirebaseDatabase.getInstance().getReference("student");
      //  myRef =  FirebaseDatabase.getInstance().getReference("student/"+stuEmail.trim());

        Intent i=getIntent();
        final String n,c,t,f,k;
        n = i.getStringExtra("name");
        c= i.getStringExtra("cllg");
        t= i.getStringExtra("toTime");
        f=i.getStringExtra("frmTime");

        k=i.getStringExtra("Tkey");


        path=n;

        toTime.setText(t);
        fromTime.setText(f);
        cllg.setText(c);
        name.setText(n);

        dbref = FirebaseDatabase.getInstance().getReference("meeting");

        meetingObj.setTeacherKey(k);
        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ask to book a meeting with the professor
                Toast.makeText(getApplicationContext(),"error after this",Toast.LENGTH_SHORT).show();
                //retrieve student data
                //"student\stuname" ru retrieve in form of stuupload
/*
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        //collectNames();
                        Toast.makeText(getApplicationContext(),"reached here!",Toast.LENGTH_SHORT).show();

                        collectNames((Map<String,StudentDataUpload>) dataSnapshot.getValue());

                       */
/* Map<String,StudentDataUpload> users=(Map<String,StudentDataUpload>) dataSnapshot.getValue();
                        for (Map.Entry<String, StudentDataUpload> entry : users.entrySet()) {
                            Map singleUser = (Map) entry.getValue();
                            if(stuEmail.equals(entry.getKey())) {
                                Toast.makeText(getApplicationContext(),"successful in retrieving",Toast.LENGTH_SHORT).show();

                                stuupload.name = singleUser.get("name").toString();
                                stuName=stuupload.name;
                                stuupload.cllg = singleUser.get("cllg").toString();
                                break;

                            }
                        }*//*


                      //  stuupload= dataSnapshot.getValue(StudentDataUpload.class);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Toast.makeText(getApplicationContext(),"error in retrieving",Toast.LENGTH_SHORT).show();

                        Log.w("TeacherDetail.java", "Failed to read value.", error.toException());
                    }
                });
*/



                //upload student data to teachers db
                dbref.child(n).setValue(stuupload);

                //toast
             //   Toast.makeText(getApplicationContext(),"REQUEST IS SENT",Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(TeacherDetail.this, STUDENT.class));
            finish();
        }
        return true;
    }

/*
    private void collectNames(Map<String,StudentDataUpload> users) {

      //  obj= new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, StudentDataUpload> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            //obj.add( new TeacherDataRetrieve( singleUser.get("name").toString(),
              */
/*      singleUser.get("timeTo").toString(),
                    singleUser.get("timeFRom").toString(),
                    singleUser.get("cllg").toString()));

*//*

              if((entry.getKey()).equals(stuEmail))
              {
                  stuupload.cllg=singleUser.get("cllg").toString();
                  stuupload.name=singleUser.get("name").toString();
                  stuName=stuupload.getName();
                  break;

              }
        }
       // objAdapter adapter = new objAdapter(getApplicationContext(), obj);

      //  listView.setAdapter(adapter);


    }
*/

}
