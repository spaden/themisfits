package com.loveispatientitskind.misfits.loveispatientitskind;

import android.app.FragmentManager;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Date;

public class chaplist extends AppCompatActivity {
    ImageButton lastRead,sChapters;
    private storeme nvalue;
    Network post;
    timeout time;
    Date time1,time2;
    storeme check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaplist);
        check=new storeme(getApplicationContext());
        lastRead=(ImageButton) findViewById(R.id.ltread);
        sChapters=(ImageButton) findViewById(R.id.schap);
        nvalue=new storeme(getApplicationContext());
        lastRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getlastread();
            }
        });
        sChapters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showlist();
            }
        });
        post=new Network(getApplicationContext());
        time=new timeout(getApplicationContext(),post);
        time1=new Date(System.currentTimeMillis());
        //custfrag ct=new custfrag();
        //ct.setmContext(getApplicationContext());
        //android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        //Fragment which=fm.findFragmentById(R.id.testfrag);
        //if(which == null){
          //  which=ct;
           // fm.beginTransaction().add(R.id.testfrag,which).commit();
        //}
    }
    private void getlastread(){
        int number=nvalue.getData();
        Intent i=Reading.setReading(getApplicationContext(),number);
        startActivity(i);
    }
    private void showlist(){
        Intent i=new Intent(getApplicationContext(),selectchapt.class);
        startActivity(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        time2=new Date(System.currentTimeMillis());
        time.senddiff1(time1,time2,nvalue.getreffno(),nvalue.getUserName());
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
        time.senddiff1(time1,time2,check.getreffno(),nvalue.getUserName());
        //post.checkifConnected("on destroy called 4");
    }
}
