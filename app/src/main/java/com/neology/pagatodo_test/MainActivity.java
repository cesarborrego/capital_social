package com.neology.pagatodo_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.neology.pagatodo_test.Model.PromoData;
import com.neology.pagatodo_test.adapter.PromoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<PromoData> promoDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElements();
    }

    private void initElements() {
        mRelativeLayout = (RelativeLayout) findViewById(R.id.r1);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Define a layout for RecyclerView
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Initialize a new String array
        String[] titulos = {
                "Papa John´s",
                "Papa John´s",
                "Idea Interior",
                "Burguer King",
                "El Tizoncito",
                "Chilli´s",
                "Cinépolis",
                "Zona Fittnes",
                "Wingstop",
                "Italianni´s"

        };
        String[] descripciones = {
                "Aardvark",
                "Albatross",
                "Alligator",
                "Alpaca",
                "Ant",
                "Anteater",
                "Antelope",
                "Ape",
                "Armadillo",
                "Donkey"
        };
        int[] imgs = {
                R.drawable.papa,
                R.drawable.papa1,
                R.drawable.promoidea,
                R.drawable.burger,
                R.drawable.tizon,
                R.drawable.chillis,
                R.drawable.cinepolis,
                R.drawable.zona,
                R.drawable.wing,
                R.drawable.italiannis
        };
        // Initialize a new instance of RecyclerView Adapter instance
        promoDataArrayList = new ArrayList<PromoData>();
        for (int i = 0; i<titulos.length; i++) {
            PromoData promoData = new PromoData(titulos[i],
                    descripciones[i],
                    imgs[i]);
            promoDataArrayList.add(promoData);
        }
        mAdapter = new PromoAdapter(promoDataArrayList, this);
        // Set the adapter for RecyclerView
        mRecyclerView.setAdapter(mAdapter);
    }
}
