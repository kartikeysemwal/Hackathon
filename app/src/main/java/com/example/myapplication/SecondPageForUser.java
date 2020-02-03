package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class SecondPageForUser extends AppCompatActivity {

    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4, mediaPlayer5, mediaPlayer6;
    MediaPlayer mediaPlayer11, mediaPlayer21, mediaPlayer31, mediaPlayer41, mediaPlayer51, mediaPlayer61;
    Button education, employment, healthcare, currentaffair, charity, emergencycontact;
    String lang;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        lang = intent.getStringExtra("lang");
        Toast.makeText(SecondPageForUser.this, lang, Toast.LENGTH_SHORT).show();
        setAppLocale(lang);
        setContentView(R.layout.activity_second_page_for_user);
        i=0;

        mediaPlayer1 = MediaPlayer.create(this, R.raw.education);
        mediaPlayer11 = MediaPlayer.create(this, R.raw.shiksha);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.employment);
        mediaPlayer21 = MediaPlayer.create(this, R.raw.rozgaar);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.healthcare);
        mediaPlayer31 = MediaPlayer.create(this, R.raw.swasthya);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.currentaffair);
        mediaPlayer41 = MediaPlayer.create(this, R.raw.samayekee);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.governmentpolicies);
        mediaPlayer51 = MediaPlayer.create(this, R.raw.sarkaarnitiyaan);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.emergencycontact);
        mediaPlayer61 = MediaPlayer.create(this, R.raw.apatkaleen);

        education = findViewById(R.id.education);
        employment = findViewById(R.id.employement);
        healthcare = findViewById(R.id.health);
        currentaffair = findViewById(R.id.current);
        charity = findViewById(R.id.charity);
        emergencycontact = findViewById(R.id.emergency);


        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lang.charAt(0)=='h')
                    mediaPlayer11.start();
                else
                {
                    mediaPlayer1.start();
                }

                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                    Toast.makeText(SecondPageForUser.this, "Double tap to open", Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    Intent intent1 = new Intent(getApplicationContext(), EducationUser.class);
                    startActivity(intent1);
                }
            }
        });
        employment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lang.charAt(0)=='h')
                    mediaPlayer21.start();
                else
                {
                    mediaPlayer2.start();
                }

                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                    Toast.makeText(SecondPageForUser.this, "Double tap to open", Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    Intent intent1 = new Intent(getApplicationContext(), Employement.class);
                    intent1.putExtra("lang", lang);
                    startActivity(intent1);
                }
            }
        });
        healthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lang.charAt(0)=='h')
                    mediaPlayer31.start();
                else
                {
                    mediaPlayer3.start();
                }

                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                    Toast.makeText(SecondPageForUser.this, "Double tap to open", Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    Intent intent1 = new Intent(getApplicationContext(), HealthCare.class);
                    intent1.putExtra("lang", lang);
                    startActivity(intent1);
                }
            }
        });
        currentaffair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lang.charAt(0)=='h')
                    mediaPlayer41.start();
                else
                {
                    mediaPlayer4.start();
                }

                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                    Toast.makeText(SecondPageForUser.this, "Double tap to open", Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    Intent intent1 = new Intent(getApplicationContext(), NewsRead.class);
                    intent1.putExtra("lang", lang);
                    startActivity(intent1);
                }
            }
        });
        charity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lang.charAt(0)=='h')
                    mediaPlayer51.start();
                else
                {
                    mediaPlayer5.start();
                }

                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                    Toast.makeText(SecondPageForUser.this, "Double tap to open", Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    Intent intent1 = new Intent(getApplicationContext(), GovtPolicies.class);
                    intent1.putExtra("lang", lang);
                    startActivity(intent1);
                }
            }
        });
        emergencycontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lang.charAt(0)=='h')
                    mediaPlayer61.start();
                else
                {
                    mediaPlayer6.start();
                }

                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    handler.postDelayed(r, 250);
                    Toast.makeText(SecondPageForUser.this, "Double tap to open", Toast.LENGTH_SHORT).show();
                } else if (i == 2) {
                    //Double click
                    i = 0;
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:0377778888"));
                    startActivity(callIntent);
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
