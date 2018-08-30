package com.loveispatientitskind.misfits.loveispatientitskind;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class showads implements RewardedVideoAdListener {
    private Context context;
    private  storeme putads;
    private RewardedVideoAd mRewardedVideoAd;
    public showads(Context context){
        this.context=context;
        putads=new storeme(this.context);
        MobileAds.initialize(this.context, "ca-app-pub-3329551989027593~3064343318");
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this.context);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

    }
    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3329551989027593/3895015155",
                new AdRequest.Builder().build());
    }
    public void displayAd(){
        if (mRewardedVideoAd.isLoaded()) {

            mRewardedVideoAd.show();

        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
//        Toast.makeText(this.context,"Loaded ad",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        this.loadRewardedVideoAd();
        putads.incAdsShown();

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
    public void pauseme(){

        mRewardedVideoAd.pause(this.context);
    }
    public int showfragads(){
        int i=0;

        if (mRewardedVideoAd.isLoaded()) {

            mRewardedVideoAd.show();
            i=1;
        }

        return i;
    }
    public void resumeme(){
        mRewardedVideoAd.resume(this.context);
    }
    public void destroyme()
    {
        mRewardedVideoAd.destroy(this.context);
    }
}
