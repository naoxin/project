package com.hhzmy.hhzmy;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.adapter.ViewPageAdapter;

public class Main2Activity extends AppCompatActivity {

    int []pa={R.mipmap.guide_page1,R.mipmap.guide_page2,R.mipmap.guide_page3};
    private ViewPager vp;
    ViewPageAdapter adapter;

    @Override




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        vp = (ViewPager)findViewById(R.id.vp);
        adapter=new ViewPageAdapter(pa,this);
        vp.setAdapter(adapter);
    }
}
