package com.kaproduction.malibilgiler.Pojo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kaproduction.malibilgiler.PDFActivity;
import com.kaproduction.malibilgiler.R;

import java.util.ArrayList;

/**
 * Created by reis on 29/10/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Info> arrayList = new ArrayList<>();
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

        holder.imageView.setImageResource(R.mipmap.ic_action_action_assignment_turned_in);
        holder.textView.setText(arrayList.get(position).getParent());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Info i = this.infoArrayList.get(position);
            Toast.makeText(ctx.getApplicationContext(),i.getParent().toString(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ctx.getApplicationContext(), PDFActivity.class);
            intent.putExtra("parent", i.getParent().toString());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.ctx.getApplicationContext().startActivity(intent);

           // String path = "http://www.gib.gov.tr/sites/default/files/fileadmin/user_upload/Yararli_Bilgiler/amortisman_oranlari.pdf";
           // Intent intent = new Intent(Intent.ACTION_VIEW);
           // intent.setDataAndType(Uri.parse(path), "application/pdf");
           // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

           // this.ctx.getApplicationContext().startActivity(intent);
        }
    }

    public void setFilter(ArrayList<Info> newList){

        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }



}
