package com.neology.pagatodo_test.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LeviAcosta on 23/02/2017.
 */

public class PromoData  implements Parcelable{
    private String titulo;
    private String descripcion;
    private int resImg;

    public PromoData (String titulo,
                      String descripcion,
                      int resImg) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.resImg = resImg;
    }

    protected PromoData(Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
        resImg = in.readInt();
    }

    public static final Creator<PromoData> CREATOR = new Creator<PromoData>() {
        @Override
        public PromoData createFromParcel(Parcel in) {
            return new PromoData(in);
        }

        @Override
        public PromoData[] newArray(int size) {
            return new PromoData[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(descripcion);
        parcel.writeInt(resImg);
    }
}
