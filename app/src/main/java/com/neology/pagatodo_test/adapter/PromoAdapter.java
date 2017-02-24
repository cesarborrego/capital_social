package com.neology.pagatodo_test.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.neology.pagatodo_test.DataActivity;
import com.neology.pagatodo_test.Model.PromoData;
import com.neology.pagatodo_test.R;

import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by LeviAcosta on 23/02/2017.
 */

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoViewHolder>{

    ArrayList<PromoData> promoDataArrayList;
    Activity a;

    public PromoAdapter(ArrayList<PromoData> promoDataArrayList, Activity a) {
        this.promoDataArrayList = promoDataArrayList;
        this.a = a;
    }

    @Override
    public PromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view, parent, false);
        return new PromoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PromoViewHolder holder, int position) {
        final PromoData promoData = promoDataArrayList.get(position);
        holder.titulo.setText(promoData.getTitulo());
        holder.descripcion.setText(promoData.getDescripcion());
        holder.promoImg.setImageResource(promoData.getResImg());
        holder.promoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(a.getApplicationContext(), DataActivity.class);
                intent.putExtra("data", promoData);
                a.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return promoDataArrayList.size();
    }

    public static class PromoViewHolder extends RecyclerView.ViewHolder{
        public ImageView promoImg;
        public TextView titulo;
        public TextView descripcion;

        public PromoViewHolder(View v){
            super(v);
            promoImg = (ImageView)v.findViewById(R.id.imgPromo);
            titulo = (TextView)v.findViewById(R.id.titulo);
            descripcion = (TextView)v.findViewById(R.id.descripcion);
        }
    }
}
