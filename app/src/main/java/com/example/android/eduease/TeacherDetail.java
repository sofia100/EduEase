package com.example.android.eduease;
//as displayed to the student with ask button

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherDetail extends AppCompatActivity {
TextView toTime,fromTime,name,cllg;
Button ask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        toTime=findViewById(R.id.time_to);//chk if correct connction else chng the ids
        fromTime= findViewById(R.id.time_from);
        name=findViewById(R.id.name);
        cllg=findViewById(R.id.cllg);
        ask=findViewById(R.id.ask);


        Intent i=getIntent();
        String n,c,t,f;
        n = i.getStringExtra("name");
        c= i.getStringExtra("cllg");
        t= i.getStringExtra("toTime");
        f=i.getStringExtra("frmTime");


        toTime.setText(t);
        fromTime.setText(f);
        cllg.setText(c);
        name.setText(n);

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ask to book a meeting with the professor
            }
        });

    }
}
