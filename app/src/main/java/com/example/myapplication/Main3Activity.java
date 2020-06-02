//Email password login sing up and first page
package com.example.myapplication;

import androidx.annotation.NonNull;
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

import java.util.Locale;

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
                    Toast.makeText(getApplicationContext(), String.valueOf(R.string.enterEmailAddress), Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), String.valueOf(R.string.enterPassword), Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Main3Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful())
                                {
                                    if (password.length() < 6) {
                                    } else {
                                        //Toast.makeText(Main3Activity.this, "", Toast.LENGTH_LONG).show();
                                    }
                                    Toast.makeText(Main3Activity.this, String.valueOf(R.string.reenterDetails), Toast.LENGTH_SHORT).show();
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
