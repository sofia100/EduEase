package com.example.android.eduease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class TEACHER_DASHBOARD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__dashboard);
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
                startActivity(new Intent(TEACHER_DASHBOARD.this,PROFESSOR_LoginActivity.class));
                finish();
                break;
        }
        return true;
    }

    @Override//just a comment for git

    public void onBackPressed() {
        //sign out from app even if back is pressed
            FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(TEACHER_DASHBOARD.this,PROFESSOR_LoginActivity.class));
        super.onBackPressed();

    }
}
