package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    EditText email1,pass2;
    TextView email, pass1;
    Button sgn,log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        email=findViewById(R.id.email);
        email1=findViewById(R.id.emal1);
        pass1=findViewById(R.id.pass1);
        pass2=findViewById(R.id.pass2);
        sgn=findViewById(R.id.sgn);
        log=findViewById(R.id.log);




    }
}
