package com.example.android.tourguide;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 张俊秋 on 2017/2/19.
 */

public class PlaceInfoLabs {
    private ArrayList<PlaceInfo> mPlaceInfos;
    private static PlaceInfoLabs mPlaceInfoLabs;
    private PlaceInfoLabs(){
        mPlaceInfos=new ArrayList<>();
        initData();
    }
    public static PlaceInfoLabs getInstance(Context context){
        if (mPlaceInfoLabs==null){
            mPlaceInfoLabs=new PlaceInfoLabs();
        }
        return mPlaceInfoLabs;
    }
    private void initData(){
        PlaceInfo placeA=new PlaceInfo(R.drawable.research_base_of_panda,
                R.string.panda_address,
                R.string.panda_phone,
                R.string.panda_price,
                R.string.panda_base);
        placeA.setImages(R.drawable.research_base_of_panda,
                R.drawable.panda1,
                R.drawable.child_panda,
                R.drawable.statue_of_panda,
                R.drawable.panda_location);
        placeA.setDesId(R.string.panda_des);
        PlaceInfo placeB=new PlaceInfo(R.drawable.gurung,
                R.string.gurung_address,
                R.string.gurung_phone,
                R.string.gurung_price,
                R.string.gurung);
        placeB.setImages(R.drawable.gurung,
                R.drawable.pevilion,
                R.drawable.statue,
                R.drawable.zhuge_liang,
                R.drawable.gurung_location);
        placeB.setDesId(R.string.gurung_des);
        PlaceInfo placeC=new PlaceInfo(R.drawable.the_three,
                R.string.sanyou_address,
                R.string.sanyou_phone,
                R.string.sanyou_price,
                R.string.sanyou_cave);
        placeC.setDesId(R.string.sanyou_des);
        placeC.setImages(R.drawable.the_three,
                R.drawable.bridge,
                R.drawable.door,
                R.drawable.outside,
                R.drawable.sanyou_cave_location);
        PlaceInfo placeD =new PlaceInfo(R.drawable.waterfall,
                R.string.three_gorges_waterfall_address,
                R.string.three_gorges_waterfall_phone,
                R.string.three_gorges_waterfall_price,
                R.string.three_gorges_waterfall);
        placeD.setImages(R.drawable.waterfall,
                R.drawable.blue,
                R.drawable.distant_view,
                R.drawable.fishing,
                R.drawable.three_gorges_waterfall_location);
        placeD.setDesId(R.string.three_gorges_des);
        mPlaceInfos.add(placeA);
        mPlaceInfos.add(placeB);
        mPlaceInfos.add(placeC);
        mPlaceInfos.add(placeD);
    }

    public ArrayList<PlaceInfo> getPlaceInfos() {
        return mPlaceInfos;
    }
}
