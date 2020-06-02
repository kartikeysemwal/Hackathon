package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.List;

public class EducationUser extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_user);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_books);
        new FirebaseDatabaseHelper().readBooks(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Book> books, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, EducationUser.this, books, keys);
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
