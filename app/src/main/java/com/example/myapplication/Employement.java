package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Employement extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employement);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_books);

        new FirebaseDatabaseEmployment().readBooks(new FirebaseDatabaseEmployment.DataStatus() {
            @Override
            public void DataIsLoaded(List<EmployementFirebase> employ, List<String> keys) {
                new RecyclerView_ConfigEmploy().setConfig(mRecyclerView, Employement.this, employ, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
