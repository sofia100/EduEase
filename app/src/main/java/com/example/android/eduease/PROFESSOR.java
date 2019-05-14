package com.example.android.eduease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PROFESSOR extends AppCompatActivity {
Button done;
CheckBox java,c,cpp,ds,daa,emfw,eem,act,aec,dec,short_time,long_time,both;
EditText cllg,name,timeTO,timeFrom;
//TextView slot;
    private DatabaseReference mDatabaseRef;
    public static String DATABASE_PATH = "children";
    String n,clg,tymTo,tymFrom;


    TeacherDataUpload itemUpload;
  //  private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

      mDatabaseRef = FirebaseDatabase.getInstance().getReference(DATABASE_PATH);

      itemUpload=new TeacherDataUpload();

        done = findViewById(R.id.done);
        cpp= findViewById(R.id.checkbox_cpp);
        act= findViewById(R.id.checkbox_act);
        dec= findViewById(R.id.checkbox_DEC);
        cllg=findViewById(R.id.cllg_edit);
        name=findViewById(R.id.name_edit);

        java= findViewById(R.id.checkbox_java);
        c= findViewById(R.id.checkbox_c);
        ds= findViewById(R.id.checkbox_ds);
        timeTO=findViewById(R.id.time_to);
        timeFrom=findViewById(R.id.time_from);
        both= findViewById(R.id.checkbox_both);

        daa= findViewById(R.id.checkbox_daa);
        eem= findViewById(R.id.checkbox_eem);
        aec= findViewById(R.id.checkbox_aec);
        emfw= findViewById(R.id.checkbox_emfw);
        short_time= findViewById(R.id.checkbox_short_discussion);
        long_time= findViewById(R.id.checkbox_long_class);




        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 String s =mDatabaseRef.push().getKey();
                n = name.getText().toString();
                clg = cllg.getText().toString();
                tymTo= timeTO.getText().toString();
                tymFrom = timeFrom.getText().toString();

               // Toast.makeText(getApplicationContext(),n+clg+tymFrom+tymTo,Toast.LENGTH_SHORT).show();

                itemUpload.setName(n);
                itemUpload.setCllg(clg);
                itemUpload.setTimeTo(tymTo);
                itemUpload.setTimeFRom(tymFrom);


                mDatabaseRef.child(s).setValue(itemUpload);

                Toast.makeText(getApplicationContext(),"UPLOADED DATA TO DB",Toast.LENGTH_SHORT).show();

                Intent i= new Intent(PROFESSOR.this,TEACHER_DASHBOARD.class);
              //  i.putExtra("new",true);
                startActivity(i);

            }
        });

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId())
        {
            case R.id.checkbox_long_class:
                if (checked)
                    itemUpload.setLongTime(true);
                if(!checked)
                    itemUpload.setLongTime(false);
                break;

            case R.id.checkbox_act:
                if(checked)
                    itemUpload.setAct(true);
                if(!checked)
                    itemUpload.setAct(false);
                break;

            case R.id.checkbox_daa:
                if(checked)
                    itemUpload.setDaa(true);
                if(!checked)
                    itemUpload.setDaa(false);
                break;
            case R.id.checkbox_ds:
                if(checked)
                    itemUpload.setDs(true);
                if(!checked)
                    itemUpload.setDs(false);
                break;
            case R.id.checkbox_c:
                if(checked)
                    itemUpload.setC(true);
                if(!checked)
                    itemUpload.setC(false);
                break;
            case R.id.checkbox_cpp:
                if(checked)
                    itemUpload.setCpp(true);
                if(!checked)
                    itemUpload.setCpp(false);
                break;
            case R.id.checkbox_java:
                if(checked)
                    itemUpload.setJava(true);
                if(!checked)
                    itemUpload.setJava(false);
                break;
            case R.id.checkbox_aec:
                if(checked)
                    itemUpload.setAec(true);
                if(!checked)
                    itemUpload.setAec(false);
                break;
            case R.id.checkbox_DEC:
                if(checked)
                    itemUpload.setDec(true);
                if(!checked)
                    itemUpload.setDec(false);
                break;
            case R.id.checkbox_eem:
                if(checked)
                    itemUpload.setEem(true);
                if(!checked)
                    itemUpload.setEem(false);
                break;
            case R.id.checkbox_emfw:
                if(checked)
                    itemUpload.setEmfw(true);
                if(!checked)
                    itemUpload.setEmfw(false);
                break;
            case R.id.checkbox_short_discussion:
                if(checked)
                    itemUpload.setShortTime(true);
                if(!checked)
                    itemUpload.setShortTime(false);
                break;
            case R.id.checkbox_both:
                if(checked)
                    itemUpload.setBoth(true);
                if(!checked)
                    itemUpload.setBoth(false);
                break;


        }
    }
}
