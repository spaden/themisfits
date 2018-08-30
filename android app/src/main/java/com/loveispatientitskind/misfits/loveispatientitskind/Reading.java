    package com.loveispatientitskind.misfits.loveispatientitskind;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.storage.OnObbStateChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

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
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.CheckedInputStream;

import static com.loveispatientitskind.misfits.loveispatientitskind.internalert.i;

public class Reading extends AppCompatActivity  {
    WebView ld;
    private InterstitialAd mInterstitialAd;
    int what;
    WebSettings webSetting;
    int i=0,shownads=0,shownads2=0;
    Network post;
    timeout time;
    private AdView mAdView;
    Date time1,time2;
    Button loadme;
    private storeme nvalue;
    showads disAds;
    public pauseAds myTask;
    public static Intent setReading(Context context, int i){
         Intent intent=new Intent(context,Reading.class);
         intent.putExtra("Selected",i);
         return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        //MobileAds.initialize(this, "YOUR_ADMOB_APP_ID");
        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        myTask= new pauseAds();
        myTask.execute();
        disAds=new showads(getApplicationContext());
        post=new Network(getApplicationContext());
        time=new timeout(getApplicationContext(),post);
        time1=new Date(System.currentTimeMillis());

       // Toast.makeText(getApplicationContext(),i.toString(),Toast.LENGTH_SHORT).show();

        what=getIntent().getIntExtra("Selected",0);
        nvalue=new storeme(getApplicationContext());

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3329551989027593/7771197905");

        ld=(WebView)findViewById(R.id.webtest);
        webSetting = ld.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);

        ld.loadUrl("file:///android_asset/test.html");
        //
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if(what >= 0){

         //   ld.loadUrl("javascript:gonext("+what+")");

            i=what;
        }
        loadme=(Button)findViewById(R.id.loadme);
         loadme.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(what >=0){
                     //disAds.displayAd();
                     ld.loadUrl("javascript:gonext("+what+")");

                     i=what;
                     load();

                 }else {
                     //disAds.displayAd();
                     ld.loadUrl("file:///android_asset/test.html");
                     //ld.loadUrl("javascript:gonext(0)");
                     load();
                 }
             }
         });

         Button back=(Button)findViewById(R.id.back);

         Button next=(Button)findViewById(R.id.next);

         back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    ld.loadUrl("javascript:goback("+i+")");
                    nvalue.putData(i);
                    Toast.makeText(getApplicationContext(),"You are at the beginning of the novel",Toast.LENGTH_SHORT).show();
                }else if(i>0){
                    i--;
                    ld.loadUrl("javascript:goback("+i+")");
                    nvalue.putData(i);

                }
                Toast.makeText(getApplicationContext(),"You are now Reading Chapter "+i,Toast.LENGTH_SHORT).show();
                shownads2++;

                if(shownads2%2==0){
                    disAds.displayAd();
                }else if(shownads==1){
                   disAds.displayAd();
                }
                //disAds.displayAd();

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i<=44){
                    i++;
                    ld.loadUrl("javascript:gonext("+i+")");
                    nvalue.putData(i);
                }else if(i==44){
                    ld.loadUrl("javascript:gonext("+i+")");
                    nvalue.putData(i);
                    Toast.makeText(getApplicationContext(),"You reached the end of the novel",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(),"You are now Reading Chapter "+i,Toast.LENGTH_SHORT).show();
                //i++;
                shownads++;

                if(shownads%2==0){
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        //shownads++;
                    }
                }else if(shownads==1){
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        //shownads++;
                    }
                }

            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


    }
    private void load(){
        disAds.displayAd();
        loadme.setVisibility(View.GONE);
    }


    public void loadmeany(){
        disAds.displayAd();
    }

    @Override
    protected void onPause() {
        disAds.pauseme();
        super.onPause();
        time2=new Date(System.currentTimeMillis());
        if(!nvalue.getUserName().equals("noname")){
            time.senddiff1(time1,time2,nvalue.getreffno(),nvalue.getUserName());
        }
        //post.checkifConnected("on pause called 2");
    }
    @Override
    public void onResume() {
        disAds.resumeme();
        super.onResume();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        time1=new Date(System.currentTimeMillis());
        //post.checkifConnected("on restart called 3");
    }
    public void showtoast(){
        Toast.makeText(getApplicationContext(),"Background work",Toast.LENGTH_SHORT).show();
    }
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
           // Log.i("Testing 1","Showed add");
            runOnUiThread(new Runnable() {

                public void run() {
                    try{
                       // Toast.makeText(getApplicationContext(), "Example for Toast", Toast.LENGTH_SHORT).show();
      //                  loadmeany();
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                            //shownads++;
                        }
                    }catch(Exception e){

                    }
                }
            });

        }
    }
    @Override
    protected void onDestroy() {
        disAds.pauseme();
        myTask.cancel(true);
        super.onDestroy();

        time2=new Date(System.currentTimeMillis());

        if(!nvalue.getUserName().equals("noname")){
            time.senddiff1(time1,time2,nvalue.getreffno(),nvalue.getUserName());
        }//post.checkifConnected("on destroy called 4");
    }


   private class pauseAds extends AsyncTask<Void,Void,Void>{


       @Override
       protected Void doInBackground(Void... voids) {
           MyTimerTask myTimerTask=new MyTimerTask();
           Timer timer=new Timer();
           try {
             timer.schedule(myTimerTask,10000,150000);
           }catch (Exception e ){

           }

           return null;
       }


   }

}
