package com.loveispatientitskind.misfits.loveispatientitskind;
import android.content.Context;
import android.content.SharedPreferences;
public class storeme {
    private String mydata="UserValues";
    SharedPreferences pref;
    Context context;

    private String lapmilli="ElapsedMilliSeconds";
    private int data;

    public storeme(Context context){
        this.context=context;
        pref=context.getSharedPreferences(mydata,Context.MODE_PRIVATE);
    }

    public int getData(){
       return pref.getInt(lapmilli,0);
    }

    public void putData(int tt){

        SharedPreferences.Editor editor=pref.edit();
        editor.remove(lapmilli);
        editor.putInt(lapmilli,tt);
        editor.commit();

    }

    public void putcred(String name,int reffno){
              SharedPreferences.Editor editor=pref.edit();
              editor.putString("username",name);
              editor.putInt("userreff",reffno);
              editor.commit();
    }

    public int getreffno(){
        return pref.getInt("userreff",0);
    }

    public String getUserName(){
        return pref.getString("username","noname");
    }

    public void delcred(){
        SharedPreferences.Editor editor=pref.edit();
        editor.remove("username");
        editor.remove("userreff");
        editor.commit();
    }

    public int getcred(){
        if(pref.getString("username","noname").equals("noname")  ){
               return 10;
        }else  {
            return 20;
        }
    }

    public void remchecme(){
        SharedPreferences.Editor editor=pref.edit();
        editor.remove("codvalue");
        editor.commit();
    }

    public void checkme(int code){
             SharedPreferences.Editor editor=pref.edit();
             editor.putInt("codevalue",code);
             editor.commit();
    }

    public int getcheckme(){
        return pref.getInt("codevalue",20);
    }

    public void putAdsShown(){
        SharedPreferences.Editor editor=pref.edit();
        editor.putInt("adsshown",0);
        editor.commit();
    }

    public void incAdsShown(){
        int i=pref.getInt("adsshown",0);
        i++;
        SharedPreferences.Editor editor=pref.edit();
        editor.putInt("adsshown",i);
        editor.commit();
    }

    public int getAdsShown(){
        return pref.getInt("adsshown",0);
    }

}
