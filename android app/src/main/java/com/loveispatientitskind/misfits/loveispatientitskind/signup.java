package com.loveispatientitskind.misfits.loveispatientitskind;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import static com.loveispatientitskind.misfits.loveispatientitskind.Network.code;

public class signup extends AppCompatActivity {
    EditText username;
    storeme putcred;
    EditText refname;
    Button register;

    Network network;
    TextView intern;

    String usname;
    LinearLayout changme;

    int usreff,clickedsignup=0;
    int whathapp;

    ImageView img;
    private ProgressDialog progressBar;
    boolean checkit=true;

    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        img=(ImageView)findViewById(R.id.imageme);
        changme=(LinearLayout)findViewById(R.id.linearLayout7);

        putcred=new storeme(getApplicationContext());
        network=new Network(getApplicationContext());

        username =(EditText)findViewById(R.id.username);
        refname=(EditText)findViewById(R.id.refname);
        intern=(TextView)findViewById(R.id.intern);

        Picasso.with(getApplicationContext()).load("https://raw.githubusercontent.com/spaden/misfits-beta/master/android%20app/src/main/res/drawable/adult.jpg").into(img, new Callback.EmptyCallback() {
            @Override public void onSuccess() {
                changme.setBackgroundColor(Color.parseColor("#9BF7EE"));
            }
        });

        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usname=username.getText().toString();

                usreff=Integer.parseInt(refname.getText().toString());

                 putcred.putcred(usname,usreff);

                 if(clickedsignup==0){
                     clickedsignup=1;
                     //Toast.makeText(getApplicationContext(),"who value in signup "+whathapp,Toast.LENGTH_SHORT).show();
                     if(whathapp==20){
                         network.checkifConnected(usname,String.valueOf(usreff),20);
                         register.setEnabled(false);
                         //register.setText("Please wait");
                     }else {
                         network.checkifConnected(usname,String.valueOf(usreff),10);
                         register.setEnabled(false);
                     }

                     Toast.makeText(getApplicationContext(),"If it doesn't load, go back and click again",Toast.LENGTH_SHORT).show();
                     for(int i=0;i<100;i++){}

                     ruminate();
                 }else if(clickedsignup!=0) {
                     Toast.makeText(getApplicationContext(),"If it doesn't load, go back and click again",Toast.LENGTH_SHORT).show();
                     for(int i=0;i<100;i++){}

                     ruminate();
                 }


            }
        });
        intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              internalert hey=new internalert();
              hey.show(getFragmentManager(),"123");

              register.setEnabled(true);

              whathapp=20;
              }
        });
    }
    private  void ruminate(){

        if(putcred.getcheckme() == 10){
            Toast.makeText(getApplicationContext(),"Sign Up successful",Toast.LENGTH_SHORT).show();

            putcred.putAdsShown();

            Intent i=new Intent(getApplicationContext(),chaplist.class);
            startActivity(i);

        }else if(putcred.getcheckme() == 20) {

            userplease user=new userplease();
            user.show(getFragmentManager(),"222");

            // Intent i=new Intent(getApplicationContext(),chaplist.class);
            //startActivity(i);

        }
    }
}
