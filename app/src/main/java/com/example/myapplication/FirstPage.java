package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class FirstPage extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button buttonNext;
    int selectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first_page);
        buttonNext = findViewById(R.id.buttonNext);
        radioGroup = findViewById(R.id.radioLanguage);

        selectedId = radioGroup.getCheckedRadioButtonId();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                //Toast.makeText(FirstPage.this, "1"+radioButton.getText()+"1" , Toast.LENGTH_SHORT).show();
                if(radioGroup.getCheckedRadioButtonId() == selectedId)
                {
                    setAppLocale("en");
                    //recreate();
                    Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                    intent.putExtra("lang", "en");
                    startActivity(intent);
                }
                else if(radioGroup.getCheckedRadioButtonId() == selectedId+1)
                {
                    setAppLocale("hi");
                    //recreate();
                    Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                    intent.putExtra("lang", "hi");
                    startActivity(intent);
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

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radio);

        buttonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                //Toast.makeText(FirstPage.this, radioButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }
}
