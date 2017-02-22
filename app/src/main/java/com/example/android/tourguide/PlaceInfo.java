package com.example.android.tourguide;

import java.util.ArrayList;

/**
 * Created by 张俊秋 on 2017/2/19.
 */

public class PlaceInfo {
    private int mImageResource;
    private int mNameId;
    private int mAddressId;
    private int mPhoneId;
    private int mPriceId;
    private ArrayList<Integer> mImages;

    public int getDesId() {
        return mDesId;
    }

    public void setDesId(int desId) {
        mDesId = desId;
    }

    private int mDesId;

    public int getNameId() {
        return mNameId;
    }

    public PlaceInfo(int imageResource, int addressId, int phoneId, int priceId, int nameId){
        mImageResource=imageResource;
        mAddressId=addressId;
        mPhoneId=phoneId;
        mPriceId=priceId;
        mNameId=nameId;
        mImages=new ArrayList<>();
    }

    public ArrayList<Integer> getImages() {
        return mImages;
    }

    public void setImages(int... images) {
        for(int i=0;i<images.length;i++){
            mImages.add(images[i]);
        }
    }

    public int getImageResource() {
        return mImageResource;
    }

    public int getAddressId() {
        return mAddressId;
    }

    public int getPhoneId() {
        return mPhoneId;
    }

    public int getPriceId() {
        return mPriceId;
    }
}
