
package com.example.android.eduease;

      //  import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class STUDENT extends AppCompatActivity {

CardView sigin,log;
    TextView login;
    TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        login = findViewById(R.id.login);

        sigin= findViewById(R.id.signinCard);
        log=findViewById(R.id.logCard);

        signin = findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent t=new Intent(STUDENT.this,SignUpActivity.class) ;
                startActivity(t);
            }
        });
        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent t=new Intent(STUDENT.this,SignUpActivity.class) ;
                startActivity(t);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent t=new Intent(STUDENT.this,LogInActivity.class);
                startActivity(t);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent t=new Intent(STUDENT.this,LogInActivity.class);
                startActivity(t);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i =  new Intent(STUDENT.this,MainActivity.class);
        startActivity(i);
    }
}