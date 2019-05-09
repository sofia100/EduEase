package com.example.android.eduease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PROFESSOR extends AppCompatActivity {
Button done;
CheckBox java,c,cpp,ds,daa,emfw,eem,act,aec,dec,short_time,long_time,both;
EditText cllg,name,time;
TextView slot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        done = findViewById(R.id.done);
        java= findViewById(R.id.checkbox_java);
        c= findViewById(R.id.checkbox_c);
        cpp= findViewById(R.id.checkbox_cpp);
        ds= findViewById(R.id.checkbox_ds);
        daa= findViewById(R.id.checkbox_daa);
        slot=findViewById(R.id.timing_offered_slot);
        emfw= findViewById(R.id.checkbox_emfw);
        eem= findViewById(R.id.checkbox_eem);
        aec= findViewById(R.id.checkbox_aec);
        act= findViewById(R.id.checkbox_act);
        dec= findViewById(R.id.checkbox_DEC);
        short_time= findViewById(R.id.checkbox_short_discussion);
        long_time= findViewById(R.id.checkbox_long_class);
        cllg=findViewById(R.id.cllg_edit);
        name=findViewById(R.id.name_edit);
        time=findViewById(R.id.time);
        both= findViewById(R.id.checkbox_both);

        //sign up n sign in b chk karna h
      //what view


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId())
        {
            case R.id.checkbox_long_class:
                if (checked)
                {
                    slot.setVisibility(View.VISIBLE);
                    time.setVisibility(View.VISIBLE);
                    // Put some meat on the sandwich
                }
                break;

        }
    }
}
