package com.loveispatientitskind.misfits.loveispatientitskind;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class userplease extends DialogFragment {
    public Button ok;
    public String check="Not connected";
    public Context who;

    public void setwho(Context who){
        this.who=who;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();

        View dialogView=inflater.inflate(R.layout.requestuser,null);

        ok=(Button) dialogView.findViewById(R.id.ok);

        ok.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                //checkifConnected();
            }
        });

        builder.setView(dialogView);
        return builder.create();

        // return super.onCreateDialog(savedInstanceState);
    }
    /*private void checkifConnected(){
        RequestQueue queue = Volley.newRequestQueue(this.who);
        String url="http://192.168.0.5/test.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        if(response.equals("success")){
                            check="Allow access";
                            dismiss();
                            //Toast.makeText(getContext(),"Username error please check",Toast.LENGTH_SHORT).show();
                        }else {
                            dismiss();
                        }
                    }
                }, new Response.ErrorListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Unable to connect to the server please turn on your mobile data",Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    } */
}
