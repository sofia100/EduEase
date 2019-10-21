package com.example.android.eduease;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText editID,editID2, editEmail, editPass, editRePass;
    private TextView registerTx;
    private FirebaseAuth fbAuth;
    CardView register;
    private DatabaseReference stuDatabaseRef;
    public static String DATABASE_PATH = "student";
    private ProgressBar progressBar;
    StudentDataUpload stuitemUpload;
    String sn,sclg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fbAuth = FirebaseAuth.getInstance();
        stuDatabaseRef = FirebaseDatabase.getInstance().getReference(DATABASE_PATH);

        stuitemUpload=new StudentDataUpload();

        register=findViewById(R.id.card_reg);
        editID = findViewById(R.id.editID);
        editID2 = findViewById(R.id.editID2);
        editEmail = findViewById(R.id.textemailID);
        editPass = findViewById(R.id.editPasskey);
        editRePass = findViewById(R.id.editPasskey2);
        registerTx = findViewById(R.id.register);

        progressBar = findViewById(R.id.progress_bar_sign_up);
        progressBar.setVisibility(View.INVISIBLE);

        getSupportActionBar().hide();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegister();
            }
        });
        registerTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegister();
            }
        });
    }

    void userRegister() {
        final String id = editID.getText().toString().trim();
        final String id2 = editID2.getText().toString().trim();
        final String email = editEmail.getText().toString().trim();
        String pass = editPass.getText().toString().trim();
        String rePass = editRePass.getText().toString().trim();

        if(id.isEmpty() || email.isEmpty() || pass.isEmpty() || rePass.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!pass.equals(rePass)) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        fbAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration Successful!", Toast.LENGTH_SHORT).show();
                            String student =stuDatabaseRef.push().getKey();

                            sn = id;//editID.getText().toString();
                            sclg =id2;// editID2.getText().toString();

                            stuitemUpload.setName(sn);
                            stuitemUpload.setCllg(sclg);
                            stuitemUpload.setKey(student);
//child name email in db
                            String e= email.replace('@','_');
                            e= e.replace('.','_');
                            stuDatabaseRef.child(e).setValue(stuitemUpload);

                            Intent i = new Intent(SignUpActivity.this, LogInActivity.class);
//                            i.putExtra("StudentEmail",email);
//
                            startActivity(i);
                        }

                        else {
                            Toast.makeText(getApplicationContext(), "Error... Please Try Again.", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }
}