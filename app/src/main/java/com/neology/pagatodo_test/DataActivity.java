package com.neology.pagatodo_test;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.neology.pagatodo_test.Model.PromoData;

public class DataActivity extends AppCompatActivity {
    ImageView img;
    TextView titulo;
    TextView descripcion;
    PromoData promoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        promoData = getIntent().getParcelableExtra("data");
        initElements();
    }

    private void initElements() {
        img = (ImageView)findViewById(R.id.image_paralax);
        img.setImageResource(promoData.getResImg());
        titulo = (TextView)findViewById(R.id.tituloPromo1);
        titulo.setText(promoData.getTitulo());
        descripcion = (TextView)findViewById(R.id.descripcion1);
        descripcion.setText(promoData.getDescripcion());
    }

}
