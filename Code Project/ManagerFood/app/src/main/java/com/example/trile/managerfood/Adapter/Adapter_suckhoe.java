package com.example.trile.managerfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trile.managerfood.DetailCookActivity;
import com.example.trile.managerfood.DetailHearthActivity;
import com.example.trile.managerfood.Models.md_main_ds;
import com.example.trile.managerfood.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by DELL on 5/8/2018.
 */

public class Adapter_suckhoe extends RecyclerView.Adapter<Adapter_suckhoe.ViewHolder> {

    private Context context;
    private ArrayList<md_main_ds> arrayList;

    public Adapter_suckhoe(Context context, ArrayList<md_main_ds> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public Adapter_suckhoe.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_chuyengia,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Adapter_suckhoe.ViewHolder holder, final int position) {
        Picasso.with(context).load(arrayList.get(position).getImg()).into(holder.img);
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvDesciption.setText(arrayList.get(position).getDesciption());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, DetailHearthActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("suckhoe",arrayList.get(position).getName());
                myIntent.putExtra("bundle", bundle);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvName;
        TextView tvDesciption;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_mon);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDesciption = (TextView)itemView.findViewById(R.id.tv_desciption);
        }
    }
}
