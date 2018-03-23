package com.example.mrrobot.socket3;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    public void signOut() {
        auth.signOut();
    }
private TextView a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            signOut();
            Toast.makeText(Main2Activity.this, "SIGNED OUT!SIGN IN", Toast.LENGTH_SHORT).show();

        }


        setContentView(R.layout.activity_main2);
        a= (TextView) findViewById(R.id.textView3);
        b= (TextView) findViewById(R.id.textView2);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.pass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.button2);
        btnLogin = (Button) findViewById(R.id.button);
        btnReset = (Button) findViewById(R.id.button5);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/lemonmilk.otf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/lemonmilkbold.otf");

        b.setTypeface(custom_font);
        a.setTypeface(custom_font);
        btnLogin.setTypeface(custom_font1);
        btnSignup.setTypeface(custom_font1);
        btnReset.setTypeface(custom_font);



        progressBar.setVisibility(View.GONE);

        auth = FirebaseAuth.getInstance();




    }
            public void aa(View view) {
                Intent a = new Intent(Main2Activity.this, SignUpactivity.class);
                startActivity(a);

            }

            public void ad(View view) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.password));
                                    } else {
                                        Toast.makeText(Main2Activity.this, getString(R.string.aaas), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

            }




            public void gg(View view) {
                startActivity(new Intent(Main2Activity.this, Reset.class));
            }

    }









