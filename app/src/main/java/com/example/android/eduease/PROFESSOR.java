package com.example.android.eduease;

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
EditText cllg,name,time;
//TextView slot;
    private DatabaseReference mDatabaseRef;
    public static String DATABASE_PATH = "children";

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
        time=findViewById(R.id.time);
        both= findViewById(R.id.checkbox_both);

        daa= findViewById(R.id.checkbox_daa);
        eem= findViewById(R.id.checkbox_eem);
        aec= findViewById(R.id.checkbox_aec);
        emfw= findViewById(R.id.checkbox_emfw);
        short_time= findViewById(R.id.checkbox_short_discussion);
        long_time= findViewById(R.id.checkbox_long_class);

        itemUpload.setName(name.getText().toString());
        itemUpload.setCllg(cllg.getText().toString());
        itemUpload.setTime(time.getText().toString());


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 String s =mDatabaseRef.push().getKey();


                 mDatabaseRef.child(s).setValue(itemUpload);

                Toast.makeText(getApplicationContext(),"UPLOADED DATA TO DB",Toast.LENGTH_SHORT).show();

            }
        });





    }

    //errors in chk boxes too
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId())
        {
            case R.id.checkbox_long_class:
                if (checked)
                    itemUpload.setLongTime(true);
                break;

            case R.id.checkbox_act:
                if(checked)
                    itemUpload.setAct(true);
                break;

            case R.id.checkbox_daa:
                if(checked)
                    itemUpload.setDaa(true);
                break;
            case R.id.checkbox_ds:
                if(checked)
                    itemUpload.setDs(true);
                break;
            case R.id.checkbox_c:
                if(checked)
                    itemUpload.setC(true);
                break;
            case R.id.checkbox_cpp:
                if(checked)
                    itemUpload.setCpp(true);
                break;
            case R.id.checkbox_java:
                if(checked)
                    itemUpload.setJava(true);
                break;
            case R.id.checkbox_aec:
                if(checked)
                    itemUpload.setAec(true);
                break;
            case R.id.checkbox_DEC:
                if(checked)
                    itemUpload.setDec(true);
                break;
            case R.id.checkbox_eem:
                if(checked)
                    itemUpload.setEem(true);
                break;
            case R.id.checkbox_emfw:
                if(checked)
                    itemUpload.setEmfw(true);
                break;
            case R.id.checkbox_short_discussion:
                if(checked)
                    itemUpload.setShortTime(true);
                break;
            case R.id.checkbox_both:
                if(checked)
                    itemUpload.setBoth(true);
                break;


        }
    }
}
