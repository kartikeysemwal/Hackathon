package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import java.net.URL;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HealthCare extends AppCompatActivity {
    private TextView text1;
    private PDFView pdfview;
    Intent intent;
    String lang;
    private FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mref=database.getReference("url");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);
        pdfview = findViewById(R.id.pdfview);
        text1=(TextView)findViewById(R.id.text1);
        intent = getIntent();
        lang = intent.getStringExtra("lang");
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                text1.setText(value);
                Toast.makeText(HealthCare.this, "Updated", Toast.LENGTH_SHORT).show();
                String url = text1.getText().toString();
                new RetrivePdfStream().execute(url);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HealthCare.this, "Failed to load", Toast.LENGTH_SHORT).
                show();
            }
        });
    }
    class RetrivePdfStream extends AsyncTask<String,Void,InputStream>
    {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url;
                String[] words= strings[0].split("\\s");
                if(lang.charAt(0)=='h')
                {
                    words[1].trim();
                    url=new URL (words[1]);
                }
                else
                {
                    words[0].trim();
                    url=new URL (words[0]);
                }
                HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
                if (urlConnection.getResponseCode()==200)
                {
                    inputStream=new BufferedInputStream((urlConnection.getInputStream()));
                }
            }catch(IOException e){
                return null;
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfview.fromStream(inputStream).load();
        }
    }
}