package com.example.android.eduease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ChooseSubject extends AppCompatActivity {
    TextView sjava,sc,scpp,sds,sdaa,semfw,seem,sact,saec,sdec;
   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_subj);

        sjava= findViewById(R.id.checkbox_JAVA);
        sc= findViewById(R.id.checkbox_C);
        scpp= findViewById(R.id.checkbox_CPP);
        sds= findViewById(R.id.checkbox_DS);
        sdaa= findViewById(R.id.checkbox_DAA);
        semfw= findViewById(R.id.checkbox_EMFW);
        seem= findViewById(R.id.checkbox_EEM);
        saec= findViewById(R.id.checkbox_AEC);
        sact= findViewById(R.id.checkbox_ACT);
        sdec= findViewById(R.id.checkbox_DEC);

        sjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","JAVA");
                startActivity(intent);
            }
        });
        semfw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","EMFW");
                startActivity(intent);
            }
        });
        seem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","EEM");
                startActivity(intent);
            }
        });
        sdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","DEC");
                startActivity(intent);
            }
        });
        scpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","CPP");
                startActivity(intent);
            }
        });
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","C");
                startActivity(intent);
            }
        });
        sdaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","DAA");
                startActivity(intent);
            }
        });
        sact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","ACT");
                startActivity(intent);
            }
        });
        sds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","DS");
                startActivity(intent);
            }
        });
        saec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), STUDENT_DASHBOARD.class);
                intent.putExtra("subject","AEC");
                startActivity(intent);
            }
        });

    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId())
        {
            case R.id.checkbox_CSE:
                if (checked)
                {
                    sdaa.setVisibility(View.VISIBLE);
                    scpp.setVisibility(View.VISIBLE);
                    sc.setVisibility(View.VISIBLE);
                    sds.setVisibility(View.VISIBLE);
                    sjava.setVisibility(View.VISIBLE);
                    semfw.setVisibility(View.GONE);
                    sact.setVisibility(View.GONE);
                    sdec.setVisibility(View.GONE);
                    saec.setVisibility(View.GONE);
                    seem.setVisibility(View.GONE);
                }
                if (!checked){
                    // Do your coding
                    sdaa.setVisibility(View.GONE);
                    scpp.setVisibility(View.GONE);
                    sc.setVisibility(View.GONE);
                    sds.setVisibility(View.GONE);
                    sjava.setVisibility(View.GONE);
                    semfw.setVisibility(View.GONE);
                    sact.setVisibility(View.GONE);
                    sdec.setVisibility(View.GONE);
                    saec.setVisibility(View.GONE);
                    seem.setVisibility(View.GONE);

                }
                break;
            case R.id.checkbox_ETC:
                if (checked)
                {
                    semfw.setVisibility(View.VISIBLE);
                    sact.setVisibility(View.VISIBLE);
                    sdec.setVisibility(View.VISIBLE);
                    saec.setVisibility(View.VISIBLE);
                    seem.setVisibility(View.VISIBLE);
                    sdaa.setVisibility(View.GONE);
                    scpp.setVisibility(View.GONE);
                    sc.setVisibility(View.GONE);
                    sds.setVisibility(View.GONE);
                    sjava.setVisibility(View.GONE);
                    // Put some meat on the sandwich
                }
                if (!checked){
                    // Do your coding
                    semfw.setVisibility(View.GONE);
                    sact.setVisibility(View.GONE);
                    sdec.setVisibility(View.GONE);
                    saec.setVisibility(View.GONE);
                    seem.setVisibility(View.GONE);
                    sdaa.setVisibility(View.GONE);
                    scpp.setVisibility(View.GONE);
                    sc.setVisibility(View.GONE);
                    sds.setVisibility(View.GONE);
                    sjava.setVisibility(View.GONE);
                }
                break;


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id)
        {


            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ChooseSubject.this,STUDENT.class));
                finish();
                break;
        }
        return true;
    }

}