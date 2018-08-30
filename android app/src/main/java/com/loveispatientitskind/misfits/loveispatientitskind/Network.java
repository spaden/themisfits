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
    storeme intconn;
    static int code;
    String url;
    public Context which;
    public Network(Context context){
        this.which=context;
        queue= Volley.newRequestQueue(which);
        intconn=new storeme(this.which);
    }

    public void checkifConnected(String name, final String reffno,int who){
        final String hey=name;
        final int interncheck=who;
        //Toast.makeText(which,"who value "+who,Toast.LENGTH_SHORT).show();
        url="http://159.89.161.229/terror/test.php";

       //Toast.makeText(which,"INtern check"+interncheck,Toast.LENGTH_SHORT).show();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("proceed")){
                            //Toast.makeText(which,response,Toast.LENGTH_SHORT).show();
                            intconn.remchecme();
                            intconn.checkme(10);
                            //Toast.makeText(which,"code value now "+code,Toast.LENGTH_SHORT).show();
                        }else if(response.equals("forbid")){
                            intconn.remchecme();
                            intconn.checkme(20);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  //Toast.makeText(which,"Please connect to mobile data or WIFI and try again",Toast.LENGTH_SHORT).show();
                  intconn.remchecme();
                   intconn.checkme(20);
            }

        }
        ){
            @Override
            protected Map<String,String> getParams()
            {
                Map<String, String> parm=new HashMap<String, String>();
                parm.put("usname0",hey);
                parm.put("usreff0",reffno);
                parm.put("internme",String.valueOf(interncheck));
                return parm;
            }
        };
        queue.add(stringRequest);
       // Toast.makeText(which,"code value2 "+code,Toast.LENGTH_SHORT).show();

    }

    public void uptime(double diff,final String reffno,final String usname){
        final double wow=diff;
        final String hey=Double.toString(diff);
        final String adsshown=Integer.toString(intconn.getAdsShown());
        String url="http://159.89.161.229/terror/test.php";
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                     //   Toast.makeText(which,response.toString(),Toast.LENGTH_SHORT).show();
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
                parm.put("adsshown",adsshown);
                return parm;
            }
        };
        queue.add(stringRequest);

    }


}
