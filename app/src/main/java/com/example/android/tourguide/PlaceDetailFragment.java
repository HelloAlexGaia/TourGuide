package com.example.android.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 张俊秋 on 2017/2/21.
 */

public class PlaceDetailFragment extends Fragment {
    public static final String PLACE="place";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_place,container,false);

        int mPositon=getArguments().getInt(PLACE);
        PlaceInfo placeInfo=PlaceInfoLabs.getInstance(getActivity()).getPlaceInfos().get(mPositon);

        TextView tvAddress= (TextView) view.findViewById(R.id.tv_address_fragment);
        TextView tvPhone= (TextView) view.findViewById(R.id.tv_phone_fragment);
        TextView tvPrice= (TextView) view.findViewById(R.id.tv_price_fragment);
        TextView textView= (TextView) view.findViewById(R.id.tv_des);

        tvAddress.setText(placeInfo.getAddressId());
        tvPhone.setText(placeInfo.getPhoneId());
        tvPrice.setText(placeInfo.getPriceId());
        textView.setText(placeInfo.getDesId());

        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.rv_place_picture);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new FragmentAdapter(placeInfo));

        ImageView imageView= (ImageView) view.findViewById(R.id.iv_place_location);
        int size=placeInfo.getImages().size()-1;
        imageView.setImageResource(placeInfo.getImages().get(size));
        return view;
    }

    private class FragmentViewHolder extends RecyclerView.ViewHolder {
        private PlaceInfo mPlaceInfo;
        private int position;
        private ImageView mImageView;
        public FragmentViewHolder(View itemView,PlaceInfo placeInfo) {
            super(itemView);
            mPlaceInfo=placeInfo;
            mImageView= (ImageView) itemView.findViewById(R.id.fragment_headline_image);
        }
        public void bindData(int position){
            mImageView.setImageResource(mPlaceInfo.getImages().get(position));
        }
    }
    private class FragmentAdapter extends RecyclerView.Adapter<FragmentViewHolder>{
        private PlaceInfo mPlaceInfo;
        public FragmentAdapter(PlaceInfo placeInfo){
            mPlaceInfo=placeInfo;
        }

        @Override
        public FragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(getContext()).inflate(R.layout.only_image,parent,false);
            return new FragmentViewHolder(view,mPlaceInfo);
        }

        @Override
        public void onBindViewHolder(FragmentViewHolder holder, int position) {
            holder.bindData(position);
        }

        @Override
        public int getItemCount() {
            return mPlaceInfo.getImages().size()-1;
        }
    }
}
