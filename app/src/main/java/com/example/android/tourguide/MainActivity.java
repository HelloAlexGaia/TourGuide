package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlaceInfoLabs mPlaceInfoLabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= (RecyclerView) findViewById(R.id.rv_scenery_point);
        mPlaceInfoLabs=PlaceInfoLabs.getInstance(getBaseContext());
        MyAdapter myAdapter=new MyAdapter(mPlaceInfoLabs.getPlaceInfos());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mRecyclerView.setAdapter(myAdapter);
    }
    private class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPlacePhoto;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvPhone;
        private TextView tvPrice;
        private int mPosition;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivPlacePhoto= (ImageView) itemView.findViewById(R.id.iv_place_photo);
            tvName= (TextView) itemView.findViewById(R.id.tx_name);
            tvAddress= (TextView) itemView.findViewById(R.id.tv_address);
            tvPhone= (TextView) itemView.findViewById(R.id.tv_phone);
            tvPrice= (TextView) itemView.findViewById(R.id.tv_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(PlaceDetailActivity.getPlaceDetailActivity(getBaseContext(),mPosition));
                }
            });
        }
        public void bindData(PlaceInfo placeInfo,int position){
            tvName.setText(getString(placeInfo.getNameId()));
            ivPlacePhoto.setImageResource(placeInfo.getImageResource());
            tvAddress.setText(getString(placeInfo.getAddressId()));
            tvPhone.setText(getString(placeInfo.getPhoneId()));
            tvPrice.setText(getString(placeInfo.getPriceId()));
            mPosition=position;
        }
    }
    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private ArrayList<PlaceInfo> mPlaceInfos;
        public MyAdapter(ArrayList<PlaceInfo> placeInfo){
            mPlaceInfos=placeInfo;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getBaseContext());
            View view=inflater.inflate(R.layout.item_view,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindData(mPlaceInfos.get(position),position);
        }

        @Override
        public int getItemCount() {
            return mPlaceInfos.size();
        }
    }
}
