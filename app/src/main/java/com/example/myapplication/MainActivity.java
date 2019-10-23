package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText name1, contact1,dob1;
    TextView name, contact,dob;
    Button register;
    CircleImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1=findViewById(R.id.name1);
        contact1=findViewById(R.id.number1);
        name=findViewById(R.id.name);
        contact=findViewById(R.id.number);
        dob=findViewById(R.id.dob);
        dob1=findViewById(R.id.dob1);
        register=findViewById(R.id.register_btn);
        img=findViewById(R.id.image);

        dob1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePickerDialog();

            }
        });





    }

    private void showDatePickerDialog(){

        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String selected=dayOfMonth+"/"+month+"/"+year;
        dob1.setText(selected);


    }
}
