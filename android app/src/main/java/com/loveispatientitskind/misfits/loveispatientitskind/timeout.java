package com.loveispatientitskind.misfits.loveispatientitskind;

import android.content.Context;
import android.widget.Toast;

import java.util.Date;

public class timeout {
     private Date time1;
     private Date time2;
     private double time3;
     private Context context;
     private Network network;
     public timeout(Context context,Network network){
         this.context=context;
         this.network=network;

     }
     public void senddiff1(Date time1,Date time2,int reffno,String name){
         this.time1=time1;
         this.time2=time2;
         double diffms=this.time2.getTime()-this.time1.getTime();

         Toast.makeText(context," "+diffms,Toast.LENGTH_SHORT).show();

         network.uptime(diffms,String.valueOf(reffno),name);
     }

}
