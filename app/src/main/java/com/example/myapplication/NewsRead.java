package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsRead extends AppCompatActivity {

    List<String> list_news = new ArrayList();
    ListView listView;
    ArrayAdapter arrayAdapter;

    public class DownloadContent extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls)
        {
            URL url = null;
            HttpURLConnection urlConnection = null;
            String result = "";

            try
            {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data= reader.read();
                while(data!=-1)
                {
                    char current = (char) data;
                    result += current;
                    data = reader.read();

                }

                return  result;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return String.valueOf(R.string.failed);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_read);

        listView = findViewById(R.id.listView);

        DownloadContent task = new DownloadContent();
        String result=null;
        try
        {
            result = task.execute("https://www.indiatoday.in/news.html").get();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        Pattern websiteNews = Pattern.compile("p title=\"(.*?)\"");
        Matcher mpwebsiteNews = websiteNews.matcher(result);
        int i=0;

        while (mpwebsiteNews.find()) {
            list_news.add(mpwebsiteNews.group(1));
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list_news);
        listView.setAdapter(arrayAdapter);
    }
}
