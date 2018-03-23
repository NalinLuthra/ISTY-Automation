package com.example.mrrobot.socket3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static Socket s;
    private static ServerSocket ss;
    private EditText e;
    private EditText f;
    private TextView b;
    private Button c,l;




    private TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = (EditText)  findViewById(R.id.editText);
        f = (EditText)  findViewById(R.id.editText2);
        a = (TextView) findViewById(R.id.textView8);
        b = (TextView) findViewById(R.id.textView9);
        l = (Button) findViewById(R.id.button3);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/lemonmilk.otf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),  "fonts/lemonmilkbold.otf");

        Button send = (Button) findViewById(R.id.send);
        send.setTypeface(custom_font1);
        l.setTypeface(custom_font1);
        a.setTypeface(custom_font);
        b.setTypeface(custom_font);






        send.setOnClickListener(this);



    }
    public void klna(View view) {
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
        finish();
           }

    @Override
    public void onClick(View view) {

        myTask mt = new myTask();
        mt.execute();
    }











    class myTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String ip = e.getText().toString();
                s = new Socket((ip), 8000);
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                dos.writeUTF(f.getText().toString());

                //read input stream
                DataInputStream dis2 = new DataInputStream(s.getInputStream());
                InputStreamReader disR2 = new InputStreamReader(dis2);
                BufferedReader br = new BufferedReader(disR2);//create a BufferReader object for input

                s.close();

            } catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }
    }
}
