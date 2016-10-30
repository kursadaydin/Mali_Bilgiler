package com.kaproduction.deneme;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    Intent intent;

    Animator animator;

    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                intent = new Intent(SplashActivity.this, MainActivity.class);
               showAnimation(relativeLayout);
                startActivity(intent);
                finish();
            }

        }, 3300);


    }

    private void showAnimation(final View v){
        int cx= v.getLeft()+(4*v.getRight()/5);
        int cy= v.getTop()+(4*v.getBottom()/5);
        int radius = Math.max(v.getWidth(),v.getHeight());

        animator = ViewAnimationUtils.createCircularReveal(v,cx,cy,radius,0);

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
