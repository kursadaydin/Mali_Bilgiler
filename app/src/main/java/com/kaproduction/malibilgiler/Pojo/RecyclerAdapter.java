package com.kaproduction.malibilgiler.Pojo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kaproduction.malibilgiler.PDFActivity;
import com.kaproduction.malibilgiler.R;

import java.util.ArrayList;

/**
 * Created by reis on 29/10/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Info> arrayList;
    Context ctx;

    public RecyclerAdapter(ArrayList<Info> arrayList, Context ctx) {
        this.ctx = ctx;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(v,ctx.getApplicationContext(),arrayList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.imageView.setImageResource(R.drawable.ic_action_ok);
        holder.textView.setText(arrayList.get(position).getParent());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setFilter(ArrayList<Info> newList) {

        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;
        ArrayList<Info> infoArrayList = new ArrayList<>();
        Context ctx;


        public MyViewHolder(View itemView, Context ctx, ArrayList<Info> infoArrayList) {
            super(itemView);
            this.ctx = ctx;
            this.infoArrayList = infoArrayList;
            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(R.id.recyler_image);
            textView = (TextView) itemView.findViewById(R.id.recylerText);
            textView.setTextColor(Color.WHITE);


        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Info i = arrayList.get(position);
            Intent intent = new Intent(ctx.getApplicationContext(), PDFActivity.class);
            intent.putExtra("parent", i.getParent().toString());
            intent.putExtra("url", i.getUrl().toString());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.ctx.getApplicationContext().startActivity(intent);

        }


    }



}
