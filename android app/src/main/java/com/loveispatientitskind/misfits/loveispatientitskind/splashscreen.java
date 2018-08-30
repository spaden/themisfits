package com.loveispatientitskind.misfits.loveispatientitskind;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Date;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.squareup.picasso.Picasso;

public class splashscreen extends AppCompatActivity {
    RequestQueue queue;
    showads testme;
    Network post;
    storeme check;
    timeout time;
    Date time1,time2;

    ImageView imageView;

    private  int whathapp;

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        testme=new showads(getApplicationContext());

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        imageView=(ImageView)findViewById(R.id.front);

        check=new storeme(getApplicationContext());
        post=new Network(getApplicationContext());
        time=new timeout(getApplicationContext(),post);
        time1=new Date(System.currentTimeMillis());

        final Button go=(Button) findViewById(R.id.go);

        queue = Volley.newRequestQueue(this);
       // post.checkifConnected("on create 1");

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                testservice();
                gonext();
               // testme.displayAd();
            }
        });
        Picasso.with(this)
                .load("https://raw.githubusercontent.com/spaden/misfits-beta/master/android%20app/src/main/res/drawable/front.jpg")
                .into(imageView);


    }

    @Override
    protected void onPause() {
        testme.pauseme();
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
    public void onResume() {
        testme.resumeme();
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        testme.destroyme();
        super.onDestroy();

        time2=new Date(System.currentTimeMillis());

        if(!check.getUserName().equals("noname")){
            time.senddiff1(time1,time2,check.getreffno(),check.getUserName());
        }

        //post.checkifConnected("on destroy called 4");
    }
   private  void testservice(){


   }
    private  void gonext(){
        //check.delcred();

        int ct=check.getcred();

        if(ct==10){
               startService(new Intent(this,notifications.class));
               i=new Intent(getApplicationContext(),signup.class);
               Toast.makeText(getApplicationContext(),"Please fill the detailis",Toast.LENGTH_SHORT).show();
        }else if(ct==20){
            testme.displayAd();
            Toast.makeText(getApplicationContext(),"Welcome back",Toast.LENGTH_SHORT).show();

            i=new Intent(getApplicationContext(),chaplist.class);
        }

        startActivity(i);
    }
}
