package com.example.agustinmadina.sandwichshop;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by agustin.madina on 27/01/2015.
 */
public class Sandwich implements Parcelable {
    public String mBread;
    public String mSpecialSauce;
    public String mBacon;
    public String mOnion;



    public Sandwich(String mBread,String mSpecialSauce, String mBacon,String mOnion){
        this.mBread = mBread;
        this.mSpecialSauce = mSpecialSauce;
        this.mBacon=mBacon;
        this.mOnion=mOnion;
    }

    public void setmBread(String mBread) {
        this.mBread = mBread;
    }


    public String getmBread() {

        return mBread;
    }

    public void setmSpecialSauce(String mSpecialSauce) {
        this.mSpecialSauce = mSpecialSauce;
    }

    public void setmBacon(String mBacon) {
        this.mBacon = mBacon;
    }

    public void setmOnion(String mOnion) {
        this.mOnion = mOnion;
    }

    public String getmSpecialSauce() {

        return mSpecialSauce;
    }

    public String getmBacon() {
        return mBacon;
    }

    public String getmOnion() {
        return mOnion;
    }

    private Sandwich(Parcel source) {

        mBread=source.readString();
        mSpecialSauce=source.readString();
        mBacon=source.readString();
        mOnion=source.readString();

    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mBread);
        dest.writeString(mSpecialSauce);
        dest.writeString(mBacon);
        dest.writeString(mOnion);
    }
    public static final Parcelable.Creator<Sandwich> CREATOR = new Parcelable.Creator<Sandwich>() {

        @Override
        public Sandwich createFromParcel(Parcel source) {
            return new Sandwich(source);
        }

        @Override
        public Sandwich[] newArray(int size) {
            return new Sandwich[size];
        }
    };
}

