package com.example.myapplication;

import androidx.annotation.NonNull;

import com.example.myapplication.Book;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseEmployment {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceBooks;
    private List<EmployementFirebase> employs = new ArrayList<>();

    public interface DataStatus
    {
        void DataIsLoaded(List<EmployementFirebase> employ, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseEmployment() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceBooks = mDatabase.getReference("employment");
    }

    public void readBooks(final DataStatus dataStatus)
    {
        mReferenceBooks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                employs.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    EmployementFirebase employ =  keyNode.getValue(EmployementFirebase.class);
                    employs.add(employ);
                }
                dataStatus.DataIsLoaded(employs, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
