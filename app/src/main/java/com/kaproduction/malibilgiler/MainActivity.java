package com.kaproduction.malibilgiler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ExpandableListView;


import com.kaproduction.malibilgiler.Data.ExpandableListViewData;
import com.kaproduction.malibilgiler.Other.ExpandableListViewAdapter;
import com.kaproduction.malibilgiler.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ExpandableListView expandableListView;
    HashMap<String, List<String>> Movies_category;
    List<String> Movies_list;
    ExpandableListViewAdapter adapter;

    CoordinatorLayout coordinatorLayoutMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayoutMainActivity = (CoordinatorLayout) findViewById(R.id.coordinatorLayoutMainActivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher1);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //Deneme Yourum Yazildi......
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        expandableListView = (ExpandableListView) findViewById(R.id.exp_list);
        Movies_category = ExpandableListViewData.getInfo();
        Movies_list = new ArrayList<String>(Movies_category.keySet());
        adapter = new ExpandableListViewAdapter(this, Movies_category, Movies_list);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int parent, int child, long l) {
                String result = (String) adapter.getChild(parent,child);
                alertDialog(result);
               // Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                return true;
            }
        });
        expandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (ExpandableListView.getPackedPositionType(id) == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
                    int groupPosition = ExpandableListView.getPackedPositionGroup(id);
                    int childPosition = ExpandableListView.getPackedPositionChild(id);
                    String text = (String) adapter.getChild(groupPosition,childPosition);
                    String heading = (String) adapter.getGroup(groupPosition);
                    alertDialogForClipboard(heading,text);
                }

                return true;
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Kapat")
                    .setMessage("Uygulamadan Çıkmak İster Misiniz?")
                    .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

            // super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_detay) {
            // Handle the camera action
            Intent i = new Intent(this,TabbedActivity.class);
            i.putExtra("TAB_ID",0);
            startActivity(i);
        } else if (id == R.id.nav_vergi) {
            Intent i1 = new Intent(this,TabbedActivity.class);
            i1.putExtra("TAB_ID",0);
            startActivity(i1);

        } else if (id == R.id.nav_sosyal) {
            Intent i2 = new Intent(this,TabbedActivity.class);
            i2.putExtra("TAB_ID",1);
            startActivity(i2);

        } else if (id == R.id.nav_makro) {
            Intent i3 = new Intent(this,TabbedActivity.class);
            i3.putExtra("TAB_ID",2);
            startActivity(i3);

        } else if (id == R.id.nav_paylas) {
            sendIntent();

        } else if (id == R.id.nav_eposta) {
            mailIntent();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void mailIntent() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mali Bilgiler Android Uygulaması");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Mali hayattaki en güncel pratik bilgileri takip etmek için lütfen uygulamayı kullanınız....");
        startActivity(Intent.createChooser(emailIntent, "E-posta Gönder..."));
    }

    private void sendIntent() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Mali Bilgiler Android Uygulaması Yayınlandı.....");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void sendToDoc(String result) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, result);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void alertDialog(final String rst){
        new AlertDialog.Builder(this)
                .setTitle("Paylaş")
                .setMessage("Bilgiyi Paylaşmak İster Misiniz?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        sendToDoc(rst);
                    }
                })
                .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();

    }

    private void copyToClipboard(String text) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
        }
    }

    private  void alertDialogForClipboard(final String heading, final String text){
        new AlertDialog.Builder(this)
                .setTitle(heading)
                .setMessage("Bilgiyi Kopyalamak İster Misiniz?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        copyToClipboard(text);
                        Snackbar.make(coordinatorLayoutMainActivity, "Başarılı bir şekilde kopyalama işlemi sonuçlandı.", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                })
                .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();



    }

}