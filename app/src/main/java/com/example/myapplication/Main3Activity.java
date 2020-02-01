//Email password login sing up and first page
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    EditText email1,pass2;
    TextView email, pass1;
    Button sgn,log;
    String lang;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        lang = intent.getStringExtra("lang");
        setAppLocale(lang);

        setContentView(R.layout.activity_main3);
        email=findViewById(R.id.email);
        email1=findViewById(R.id.emal1);
        pass1=findViewById(R.id.pass1);
        pass2=findViewById(R.id.pass2);
        sgn=findViewById(R.id.sgn);
        log=findViewById(R.id.log);
        Toast.makeText(Main3Activity.this, lang, Toast.LENGTH_SHORT).show();



        sgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                intent.putExtra("lang", lang);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = email1.getText().toString();
                final String password = pass2.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Main3Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                //progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        //pass2.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(Main3Activity.this, "", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(Main3Activity.this, SecondPageForUser.class);
                                    intent.putExtra("lang", lang);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });

        /*DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        Map<String, String> values = new HashMap<>();
        values.put("Name", "Kartikey");

        databaseReference.push().setValue(values, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if(databaseError == null)
                    Toast.makeText(Main3Activity.this, "Successful", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(Main3Activity.this, "Not successful " + databaseError.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });*/
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
