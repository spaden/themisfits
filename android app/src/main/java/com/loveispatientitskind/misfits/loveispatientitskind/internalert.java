package com.loveispatientitskind.misfits.loveispatientitskind;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class internalert extends DialogFragment {
    public static int i=0;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setMessage("Enter your email and password in the above text fields now and click register").setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        i=1;
                        dismiss();
                    }
                });
        return builder.create();


       // return super.onCreateDialog(savedInstanceState);
    }

}
