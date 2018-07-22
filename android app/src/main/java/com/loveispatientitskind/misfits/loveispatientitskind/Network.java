package com.loveispatientitskind.misfits.loveispatientitskind;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Network {
    RequestQueue queue;
    int interncheck=0;
    int code;
    String url;
    public Context which;
    public Network(Context context){
        this.which=context;
        queue= Volley.newRequestQueue(which);
    }

    public int checkifConnected(String name, final String reffno,int who){
        final String hey=name;
        url="http://192.168.0.6/test.php";
        if(who == 0){
            interncheck=0;
        }else if(who == 2){
            interncheck=20;
        }

        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("proceed")){
                            code=1;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                   Toast.makeText(which,"Please connect to mobile data or WIFI and try again",Toast.LENGTH_SHORT).show();

            }

        }
        ){
            @Override
            protected Map<String,String> getParams()
            {
                Map<String, String> parm=new HashMap<String, String>();
                parm.put("usname0",hey);
                parm.put("usreff0",reffno);
                parm.put("intern0",String.valueOf(interncheck));
                return parm;
            }
        };
        queue.add(stringRequest);
        return code;
    }

    public void uptime(double diff,final String reffno,final String usname){
        final double wow=diff;
        final String hey=Double.toString(diff);
        String url="http://192.168.0.6/test.php";
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(which,response.toString(),Toast.LENGTH_SHORT).show();
                        code=1;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(which,"Please connect to mobile data or WIFI and try again",Toast.LENGTH_SHORT).show();

            }

        }
        ){
            @Override
            protected Map<String,String> getParams()
            {
                Map<String, String> parm=new HashMap<String, String>();
                parm.put("ustime",hey);
                parm.put("usreff",reffno);
                parm.put("usname",usname);
                return parm;
            }
        };
        queue.add(stringRequest);
    }


}
