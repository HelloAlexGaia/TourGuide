package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by 张俊秋 on 2017/2/21.
 */

public class PlaceDetailActivity extends AppCompatActivity {
    public static final String PLACEACTARG="placeactarg";
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewPager= (ViewPager) findViewById(R.id.vp_place);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PlaceDetailFragment placeDetailFragment=new PlaceDetailFragment();
                Bundle bundle=new Bundle();
                bundle.putInt(PlaceDetailFragment.PLACE,position);
                placeDetailFragment.setArguments(bundle);
                return placeDetailFragment;
            }

            @Override
            public int getCount() {
                return PlaceInfoLabs.getInstance(getBaseContext()).getPlaceInfos().size();
            }
        });
        mViewPager.setCurrentItem(getIntent().getIntExtra(PLACEACTARG,0));
    }

    public static Intent getPlaceDetailActivity(Context context,int position){
        Intent intent=new Intent(context,PlaceDetailActivity.class);
        intent.putExtra(PLACEACTARG,position);
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
