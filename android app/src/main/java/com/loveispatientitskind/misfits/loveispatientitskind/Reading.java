    package com.loveispatientitskind.misfits.loveispatientitskind;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.storage.OnObbStateChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

import static com.loveispatientitskind.misfits.loveispatientitskind.internalert.i;

public class Reading extends AppCompatActivity {
    WebView ld;
    int what;
    WebSettings webSetting;
    int i=0;
    Network post;
    timeout time;
    Date time1,time2;
    Button loadme;
    private storeme nvalue;
    public static Intent setReading(Context context, int i){
         Intent intent=new Intent(context,Reading.class);
         intent.putExtra("Selected",i);
         return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        post=new Network(getApplicationContext());
        time=new timeout(getApplicationContext(),post);
        time1=new Date(System.currentTimeMillis());
//      new Fetch().execute();
       // Toast.makeText(getApplicationContext(),i.toString(),Toast.LENGTH_SHORT).show();
        what=getIntent().getIntExtra("Selected",0);
        nvalue=new storeme(getApplicationContext());
        ld=(WebView)findViewById(R.id.webtest);
        webSetting = ld.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);
        ld.loadUrl("file:///android_asset/test.html");
        //

        if(what >= 0){

         //   ld.loadUrl("javascript:gonext("+what+")");

            i=what;
        }
        loadme=(Button)findViewById(R.id.loadme);
         loadme.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(what >=0){

                     ld.loadUrl("javascript:gonext("+what+")");

                     i=what;
                     load();
                 }else {
                     ld.loadUrl("file:///android_asset/test.html");
                     load();
                 }
             }
         });
        Button back=(Button)findViewById(R.id.back);
        Button next=(Button)findViewById(R.id.next);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                ld.loadUrl("javascript:goback("+i+")");
                nvalue.putData(i);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                ld.loadUrl("javascript:gonext("+i+")");
                nvalue.putData(i);
            }
        });
    }
    private void load(){
        loadme.setVisibility(View.GONE);


    }
    @Override
    protected void onPause() {
        super.onPause();
        time2=new Date(System.currentTimeMillis());
        if(!nvalue.getUserName().equals("noname")){
            time.senddiff1(time1,time2,nvalue.getreffno(),nvalue.getUserName());
        }
        //post.checkifConnected("on pause called 2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        time1=new Date(System.currentTimeMillis());
        //post.checkifConnected("on restart called 3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        time2=new Date(System.currentTimeMillis());
        if(!nvalue.getUserName().equals("noname")){
            time.senddiff1(time1,time2,nvalue.getreffno(),nvalue.getUserName());
        }//post.checkifConnected("on destroy called 4");
    }
    private class Fetch extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {


            return 0;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
//            Toast.makeText(getApplicationContext(),integer,Toast.LENGTH_SHORT).show();
        }
    }
}
