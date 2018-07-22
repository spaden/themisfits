package com.loveispatientitskind.misfits.loveispatientitskind;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class signup extends AppCompatActivity {
    EditText username;
    storeme putcred;
    EditText refname;
    Button register;
    Network network;
    TextView intern;
    String usname;
    int usreff;
    int whathapp=0;
    private ProgressDialog progressBar;
    boolean checkit=true;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
         putcred=new storeme(getApplicationContext());
        network=new Network(getApplicationContext());
        username =(EditText)findViewById(R.id.username);
        refname=(EditText)findViewById(R.id.refname);
        intern=(TextView)findViewById(R.id.intern);


        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usname=username.getText().toString();
                usreff=Integer.parseInt(refname.getText().toString());
                 putcred.putcred(usname,usreff);
                 int code= network.checkifConnected(usname,String.valueOf(usreff),whathapp);
                 if(code == 1){
                      Toast.makeText(getApplicationContext(),"Sign Up successful",Toast.LENGTH_SHORT).show();
                      Intent i=new Intent(getApplicationContext(),chaplist.class);
                      startActivity(i);
                 }else {
                     userplease user=new userplease();
                     user.show(getFragmentManager(),"222");
                    // Intent i=new Intent(getApplicationContext(),chaplist.class);
                     //startActivity(i);
                 }
            }
        });
        intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              internalert hey=new internalert();
              hey.show(getFragmentManager(),"123");
              whathapp=2;
              }
        });
    }
}
