package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText emal1,pass2,pass4;
    TextView emal, pass1,pass3;
    Button sgn,tech,stud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        emal1=findViewById(R.id.emal1);
        pass2=findViewById(R.id.pass2);
        pass4=findViewById(R.id.pass4);
        pass1=findViewById(R.id.pass1);
        pass3=findViewById(R.id.pass3);
        sgn=findViewById(R.id.sgn);
        tech=findViewById(R.id.teacher);
        stud=findViewById(R.id.student);






    }
}
