package com.example.android.eduease;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class LogInActivity extends AppCompatActivity {

    EditText editEmail, editPass;
    private FirebaseAuth fbAuth;
    private TextView loginTx, signupTx;
    CardView login,sigin;

    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        fbAuth = FirebaseAuth.getInstance();

        sigin= findViewById(R.id.sign_card);
        login=findViewById(R.id.log_card);
        editEmail = findViewById(R.id.email);
        editPass = findViewById(R.id.passkey);
        loginTx = findViewById(R.id.logIn);
        signupTx = findViewById(R.id.signUp);

        progressBar = findViewById(R.id.progress_bar_login);
        progressBar.setVisibility(View.INVISIBLE);


        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(homeIntent);
            }
        });



        signupTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(homeIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
        loginTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }

    void userLogin() {
        final String email = editEmail.getText().toString().trim();
        String pass = editPass.getText().toString().trim();

        if(email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please enter both Email and Password.", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        fbAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //Start HomeActivity
                            Toast.makeText(getApplicationContext(), "SUCCESSFULLY LOGGED IN", Toast.LENGTH_SHORT).show();
Intent i =new Intent(LogInActivity.this, ChooseSubject.class);
                            String e= email.replace('@','_');
                            e= e.replace('.','_');

                            i.putExtra("StudentEmail",e);
//email ta extract houni for old users
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed! Please Try Again.", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }
}