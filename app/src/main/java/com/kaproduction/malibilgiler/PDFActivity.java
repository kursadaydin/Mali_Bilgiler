package com.kaproduction.malibilgiler;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.kaproduction.malibilgiler.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;



public class PDFActivity extends AppCompatActivity  {
    // Remove the below line after defining your own ad unit ID.

    private static final int START_LEVEL = 1;
    private int mLevel;
    private InterstitialAd mInterstitialAd;
    private AdRequest adRequest;
    private WebView mwebView;
    private WebSettings webSettings;
    private Bundle bundle;
    private CoordinatorLayout coord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_bar_pdf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPDF);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setIcon(R.mipmap.ic_launcher1);
        coord = (CoordinatorLayout) findViewById(R.id.coordinatorLayoutPDFActivity);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5654718909401990/9642621862");
        adRequest = new AdRequest.Builder()
                .build();


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                requestNewInterstitial();
            }
        });




        mLevel = START_LEVEL;

        // webView = (WebView) findViewById(R.id.webView);
        // webView.getSettings().setJavaScriptEnabled(true);
        // webView.setVerticalScrollBarEnabled(true);
        // webView.setHorizontalScrollBarEnabled(true);
        // WebSettings webSettings = webView.getSettings();
        // webSettings.setDefaultTextEncodingName("UTF-8");
        // webView.loadData(url, "text/html; charset=UTF-8", null);
        // webView.loadUrl(url);


        if (isOnline()) {

            loadURL();

            final GestureDetector[] gs = {null};

            View.OnTouchListener onTouch = new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (gs[0] == null) {
                        gs[0] = new GestureDetector(
                                new GestureDetector.SimpleOnGestureListener() {
                                    @Override
                                    public boolean onDoubleTapEvent(MotionEvent e) {

                                        //Double Tap
                                        mwebView.setInitialScale(400);

                                        return true;
                                    }

                                    @Override
                                    public boolean onSingleTapConfirmed(MotionEvent e) {

                                        //Single Tab

                                        return false;
                                    }

                                    ;
                                });
                    }

                    gs[0].onTouchEvent(event);

                    return false;
                }
            };

            mwebView.setOnTouchListener(onTouch);


        } else {

            Snackbar snackbar = Snackbar.make(coord, "Baglantiniz yok yada site cevap vermiyor", Snackbar.LENGTH_LONG);
            snackbar.show();

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            loadURL();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        mInterstitialAd.loadAd(adRequest);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {

            super.onBackPressed();
        }
    }

    private void requestNewInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void loadURL() {
        bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        setTitle(bundle.getString("parent"));
        mwebView = (WebView) findViewById(R.id.webView);
        mwebView.setInitialScale(200);
        webSettings = mwebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        //improve webView performance
        mwebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mwebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mwebView.getSettings().setAppCacheEnabled(true);
        mwebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);

        String last3 = url.substring(url.length() - 3);

        if (last3.equals("pdf")) {
            String googleDocs = "https://docs.google.com/viewer?url=";
            String pdf_url = url;

            mwebView.loadUrl(googleDocs + pdf_url);

        } else {

            mwebView.loadUrl(url);
            //force links open in webview only

        }

        mwebView.setWebViewClient(new MyWebviewClient());


    }




    private class MyWebviewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals("www.newsweek.com")) {
                //open url contents in webview
                return false;
            } else {
                //here open external links in external browser or app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

        }

        //ProgressDialogue
        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pd = new ProgressDialog(PDFActivity.this);
            pd.setTitle("Lütfen Bekleyin..");
            pd.setMessage("Sayfa Yükleniyor..");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);
        }
    }


    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
