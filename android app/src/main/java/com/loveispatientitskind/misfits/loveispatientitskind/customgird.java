package com.loveispatientitskind.misfits.loveispatientitskind;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class customgird extends RecyclerView.Adapter<customgird.MyChapters> {
    private List<String> chaplist;
    public Detailspoint onclicklistener;
    public Context context;
    @Override
    public MyChapters onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview=LayoutInflater.from(parent.getContext()).inflate(R.layout.griditem,parent,false);

        return new MyChapters(itemview);
    }

    @Override
    public void onBindViewHolder(MyChapters holder, final int position) {
          String name=chaplist.get(position);
          holder.text.setText(name);
          holder.read.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  onclicklistener.classonclick(view,position);
              }
          });
    }

    @Override
    public int getItemCount() {
        return chaplist.size();
    }

    public class MyChapters extends RecyclerView.ViewHolder{
         public TextView text;
         public Button read;
         public MyChapters(View view){
             super(view);
             text=(TextView)view.findViewById(R.id.text1);
             read=(Button)view.findViewById(R.id.read);
         }

    }
    public customgird(List<String> chaplist,Context con,Detailspoint listener){
        this.chaplist=chaplist;
        this.context=con;
        this.onclicklistener=listener;
    }
    public interface Detailspoint {
        void classonclick(View v, int position);
    }


}
