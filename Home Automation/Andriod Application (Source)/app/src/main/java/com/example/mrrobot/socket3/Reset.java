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
import com.google.firebase.auth.FirebaseAuth;

public class Reset extends AppCompatActivity {
    private EditText inputEmail;
    private Button btnReset,ba;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        inputEmail = (EditText) findViewById(R.id.email1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        btnReset = (Button) findViewById((R.id.button6));
        ba = (Button) findViewById((R.id.button2));
        a= (TextView) findViewById(R.id.textView4);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/lemonmilk.otf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/lemonmilkbold.otf");
        btnReset.setTypeface(custom_font1);
        ba.setTypeface(custom_font1);

        a.setTypeface(custom_font);

        progressBar.setVisibility(View.GONE);

        auth = FirebaseAuth.getInstance();

//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (TextUtils.isEmpty(inputEmail.getText().toString())) {
//                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                progressBar.setVisibility(View.VISIBLE);
//                auth.sendPasswordResetEmail(inputEmail.getText().toString())
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(Reset.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    Toast.makeText(Reset.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
//                                }
//
//                                progressBar.setVisibility(View.GONE);
//                            }
//                        });
//    } });}
    }
        public void as(View view) {
        Intent i = new Intent(Reset.this, SignUpactivity.class);
        startActivity(i);
    }
    public void af(View view) {
        Toast.makeText(getApplication(), "YESSSSS", Toast.LENGTH_SHORT).show();
        if (TextUtils.isEmpty(inputEmail.getText().toString())) {
            Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(inputEmail.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Reset.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Reset.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }

                        progressBar.setVisibility(View.GONE);
                    }
                });}
    public void aa(View view) {
        finish();
    }
//    public void gg(View view) {
//        String email = inputEmail.getText().toString().trim();
//
//        if (TextUtils.isEmpty(email)) {
//            Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        progressBar.setVisibility(View.VISIBLE);
//        auth.sendPasswordResetEmail(email)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(Reset.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(Reset.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
//                        }
//
//                        progressBar.setVisibility(View.GONE);
//                    }
//                });
//    }
}
