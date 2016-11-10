package com.kaproduction.malibilgiler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.RelativeLayout;

import com.kaproduction.malibilgiler.R;

public class SplashActivity extends AppCompatActivity {


    Intent intent;
    Animator animator;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                intent = new Intent(SplashActivity.this, MainActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    showAnimation(relativeLayout);
                }
                startActivity(intent);
                finish();
            }

        }, 2500);


    }

    private void showAnimation(final View v){
        int cx= v.getLeft()+(4*v.getRight()/5);
        int cy= v.getTop()+(4*v.getBottom()/5);
        int radius = Math.max(v.getWidth(),v.getHeight());


        animator = ViewAnimationUtils.createCircularReveal(v, cx, cy, radius, 0);


        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                v.setVisibility(View.INVISIBLE);
            }
        });
        animator.start();
    }
}
