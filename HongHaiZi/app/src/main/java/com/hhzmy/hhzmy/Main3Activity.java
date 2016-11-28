package com.hhzmy.hhzmy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.fragment.Fragment1;
import com.hhzmy.fragment.Fragment2;
import com.hhzmy.fragment.Fragment3;
import com.hhzmy.fragment.Fragment4;


public class Main3Activity extends FragmentActivity implements View.OnClickListener {

    private ViewPager vp;
    private ImageButton im1;
    private ImageButton im2;
    private ImageButton im3;
    private ImageButton im4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        vp = (ViewPager)findViewById(R.id.pager_vp);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment=new Fragment1();
                        ;break;
                    case 1:
                        fragment=new Fragment2();
                        ;break;
                    case 2:
                        fragment=new Fragment3();
                        ;break;
                    case 3:
                        fragment=new Fragment4();
                        ;break;

                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        im1 = (ImageButton)findViewById(R.id.im1);
        im2 = (ImageButton)findViewById(R.id.im2);
        im3 = (ImageButton)findViewById(R.id.im3);
        im4 = (ImageButton)findViewById(R.id.im4);
        im1.setOnClickListener(this);
        im2.setOnClickListener(this);
        im3.setOnClickListener(this);
        im4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im1:
                vp.setCurrentItem(0);
                Colorsettint(0);
                ;break;
            case R.id.im2:
                vp.setCurrentItem(1);
                Colorsettint(1);
                ;break;
            case R.id.im3:
                vp.setCurrentItem(2);
                Colorsettint(2);
                ;break;
            case R.id.im4:
                vp.setCurrentItem(3);
                Colorsettint(3);
                ;break;
        }
    }
    public void Colorsettint(int i)
    {
        if(i==0)
        {
            im1.setImageResource(R.mipmap.tab_home_pressed);
            im2.setImageResource(R.mipmap.tab_class_normal);
            im3.setImageResource(R.mipmap.tab_shopping_normal);
            im4.setImageResource(R.mipmap.tab_myebuy_normal);
        }
        if(i==1)
        {
            im1.setImageResource(R.mipmap.tab_home_normal);
            im2.setImageResource(R.mipmap.tab_class_pressed);
            im3.setImageResource(R.mipmap.tab_shopping_normal);
            im4.setImageResource(R.mipmap.tab_myebuy_normal);
        }
        if(i==2)
        {
            im1.setImageResource(R.mipmap.tab_home_normal);
            im2.setImageResource(R.mipmap.tab_class_normal);
            im3.setImageResource(R.mipmap.tab_shopping_pressed);
            im4.setImageResource(R.mipmap.tab_myebuy_normal);
        }
        if(i==3)
        {
            im1.setImageResource(R.mipmap.tab_home_normal);
            im2.setImageResource(R.mipmap.tab_class_normal);
            im3.setImageResource(R.mipmap.tab_shopping_normal);
            im4.setImageResource(R.mipmap.tab_myebuy_pressed);
        }
    }

}
