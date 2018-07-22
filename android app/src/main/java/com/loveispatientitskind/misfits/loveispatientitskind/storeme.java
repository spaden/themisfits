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
}
