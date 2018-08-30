package com.loveispatientitskind.misfits.loveispatientitskind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class custfrag extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private customgird mAdapter;
    private storeme nvalue;
    showads disAds;
    public void setmContext(Context mContext){
        this.mContext=mContext;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         View v= inflater.inflate(R.layout.frag1,container,false);
         nvalue=new storeme(getContext());
         disAds=new showads(getContext());
         List<String> testone=new ArrayList<>();
        for(int i=0;i<=44;i++){
            testone.add("Chapter "+i);
        }
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter=new customgird(testone, getContext(), new customgird.Detailspoint() {
            @Override
            public void classonclick(View v, int position) {
                int i=disAds.showfragads();
                if(i==1){
                    show(position);
                }else if(i==0) {
                    disAds.showfragads();
                    show(position);
                }
            }
        });
        recyclerView.setAdapter(mAdapter);
        disAds.displayAd();
        return  v;
    }

    public void show(int positon){
        //Toast.makeText(getContext(),"Clicked "+positon,Toast.LENGTH_SHORT).show();
        nvalue.putData(positon);
        Toast.makeText(getContext(),"Selected Chapter "+nvalue.getData()+"You will enjoy this one for sure",Toast.LENGTH_SHORT).show();
        Intent i=Reading.setReading(getContext(),positon);
        startActivity(i);
    }
}
