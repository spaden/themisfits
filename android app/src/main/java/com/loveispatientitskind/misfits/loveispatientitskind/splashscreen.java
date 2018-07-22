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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Date;

public class splashscreen extends AppCompatActivity {
    RequestQueue queue;
    Network post;
    storeme check;
    timeout time;
    Date time1,time2;
    private  int whathapp;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
                 gonext();
            }
        });
    }

    @Override
    protected void onPause() {
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
        super.onDestroy();
        time2=new Date(System.currentTimeMillis());
        if(!check.getUserName().equals("noname")){
            time.senddiff1(time1,time2,check.getreffno(),check.getUserName());
        }

        //post.checkifConnected("on destroy called 4");
    }

    private  void gonext(){
        check.delcred();
        int ct=check.getcred();
        if(ct==10){
               i=new Intent(getApplicationContext(),signup.class);
               Toast.makeText(getApplicationContext(),"Please fill the detailis",Toast.LENGTH_SHORT).show();
        }else if(ct==20){
            Toast.makeText(getApplicationContext(),"Welcome back",Toast.LENGTH_SHORT).show();
            i=new Intent(getApplicationContext(),chaplist.class);
        }

        startActivity(i);
    }




}
