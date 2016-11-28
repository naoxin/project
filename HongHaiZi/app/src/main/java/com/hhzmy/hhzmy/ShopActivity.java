package com.hhzmy.hhzmy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.fragment.ShopFragment1;
import com.hhzmy.fragment.ShopFragment2;

public class ShopActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager shop;
    private TextView shangping;
    private TextView xiangqing;
    private TextView gou;
    private TextView car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        car =(TextView)findViewById(R.id.car);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShopActivity.this,ShopCarActivity.class);
                startActivity(intent);
            }
        });
        shop = (ViewPager) findViewById(R.id.shop);
        gou = (TextView) findViewById(R.id.gouwu);
        shop.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new ShopFragment1();
                        ;
                        break;
                    case 1:
                        fragment = new ShopFragment2();
                        ;
                        break;

                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });


        shangping = (TextView) findViewById(R.id.shangping);
        xiangqing = (TextView) findViewById(R.id.xiangqing);
        shangping.setOnClickListener(this);
        xiangqing.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shangping:
                shop.setCurrentItem(0);
                Colorsettint(0);
                break;
            case R.id.xiangqing:
                shop.setCurrentItem(1);
                Colorsettint(1);
                break;

        }
    }

    public void Colorsettint(int i) {
        if (i == 0) {
            shangping.setTextColor(Color.RED);
            xiangqing.setTextColor(Color.BLACK);
        }
        if (i == 1) {
            shangping.setTextColor(Color.BLACK);
            xiangqing.setTextColor(Color.RED);
        }
    }
}
