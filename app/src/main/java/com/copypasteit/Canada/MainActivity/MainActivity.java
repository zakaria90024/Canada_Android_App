package com.copypasteit.Canada.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.copypasteit.Canada.HomeActivity.HomeActivity;
import com.copypasteit.Canada.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {


    private RewardedVideoAd mRewardedVideoAd ;
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //apps pub id
        MobileAds.initialize(MainActivity.this, "ca-app-pub-3010341507881755~9806831007");
        mRewardedVideoAd  = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd .setRewardedVideoAdListener(this);
        loadRewardedVideoAd();


        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }

    //user define method for loadRewardedVideoAd load ads=================
    //===================================================================
    private void loadRewardedVideoAd() {

        //ads unit id
        mRewardedVideoAd.loadAd("ca-app-pub-3010341507881755/3788217560", new AdRequest.Builder().build());
    }

    //copy threds method onResume, onPause, onDestroy=========
    //========================================================
    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }


    //alls method of rewordvideo ad

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(this, "Congrats! You Won Currency: " , Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        super.onBackPressed();
        mRewardedVideoAd.show();
    }
}
