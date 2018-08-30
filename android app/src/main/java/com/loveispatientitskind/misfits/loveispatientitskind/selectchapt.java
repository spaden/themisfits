package com.loveispatientitskind.misfits.loveispatientitskind;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Date;

public class selectchapt extends AppCompatActivity {
    Network post;
    private AdView mAdView;
    timeout time;
    Date time1,time2;
    storeme check;
    //showads disAds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectchapt);

      //  disAds=new showads(getApplicationContext());
        //disAds.displayAd();

        post=new Network(getApplicationContext());
        time=new timeout(getApplicationContext(),post);
        time1=new Date(System.currentTimeMillis());
        check=new storeme(getApplicationContext());

        custfrag ct=new custfrag();
        ct.setmContext(getApplicationContext());

        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();

        Fragment which=fm.findFragmentById(R.id.ctlistver);
        if(which == null){
          which=ct;
         fm.beginTransaction().add(R.id.ctlistver,which).commit();
        }

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
    @Override
    protected void onPause() {
        //disAds.pauseme();
        super.onPause();
        time2=new Date(System.currentTimeMillis());

        if(!check.getUserName().equals("noname")){
            time.senddiff1(time1,time2,check.getreffno(),check.getUserName());
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
        //disAds.destroyme();
        super.onDestroy();

        time2=new Date(System.currentTimeMillis());

        if(!check.getUserName().equals("noname")){
            time.senddiff1(time1,time2,check.getreffno(),check.getUserName());
        }

        //post.checkifConnected("on destroy called 4");
    }
    @Override
    public void onResume() {
        //disAds.resumeme();
        super.onResume();
    }
}
