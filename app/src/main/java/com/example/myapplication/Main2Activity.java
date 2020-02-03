//Third page email password confirm password
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    EditText emal1,pass2,pass4;
    TextView emal, pass1,pass3;
    Button sgn,tech,stud;
    String name;
    String contact;
    String date;
    //FirebaseAuth firebaseAuth;
    String lang;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        final Intent intent = getIntent();
        lang = intent.getStringExtra("lang");
        setAppLocale(lang);

        setContentView(R.layout.activity_main2);
        emal1=findViewById(R.id.emal1);
        pass2=findViewById(R.id.pass2);
        pass4=findViewById(R.id.pass4);
        pass1=findViewById(R.id.pass1);
        pass3=findViewById(R.id.pass3);
        sgn=findViewById(R.id.sgn);

        name = intent.getStringExtra("name");
        contact = intent.getStringExtra("contact");
        date = intent.getStringExtra("date");

        //Toast.makeText(Main2Activity.this, name+" "+ contact+ " "+ date, Toast.LENGTH_SHORT).show();

        sgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emal1.getText().toString().length() == 0) {
                    emal1.setError("Enter valid email");
                }
                if(!(pass2.getText().toString()).equals(pass4.getText().toString()) && pass2.getText().toString()!="" && pass4.getText().toString()!=""){
                    pass2.setError("Password not matched");
                }
                else{
                    final Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                    String email = emal1.getText().toString();
                    String pwd = pass2.getText().toString();
                    intent.putExtra("name", name);
                    intent.putExtra("contact", contact);
                    intent.putExtra("date", date);
                    intent.putExtra("email", email);
                    intent.putExtra("password", pwd);

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

                    Map<String, String> values = new HashMap<>();
                    values.put("Name", name);
                    values.put("Contact", contact);
                    values.put("Date", date);
                    values.put("Email", email);
                    values.put("Password", pwd);

                    /*databaseReference.push().setValue(values, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if(databaseError == null)
                                Toast.makeText(Main2Activity.this, "Successful", Toast.LENGTH_SHORT).show();
                            else{
                                Toast.makeText(Main2Activity.this, "Not successful " + databaseError.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });*/

                    auth.createUserWithEmailAndPassword(email, pwd)
                            .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(Main2Activity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                    //progressBar.setVisibility(View.GONE);
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Main2Activity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        intent.putExtra("lang", lang);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                    //intent.putExtra("lang", lang);
                    //startActivity(intent);
                }
            }
        });
    }

    private void setAppLocale(String localeCode)
    {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
        {
            conf.setLocale(new Locale(localeCode.toLowerCase()));
        }
        else
        {
            conf.locale = new Locale(localeCode.toLowerCase());
        }
        res.updateConfiguration(conf, dm);
    }
}
