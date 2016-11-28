package com.hhzmy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.hhzmy.Main3Activity;

/**
 * Created by liyan on 2016/11/7.
 */

public class ViewPageAdapter extends PagerAdapter {
    int []pa;
    Context context;

    public ViewPageAdapter(int[] pa, Context context) {
        this.pa = pa;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pa.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(context, R.layout.grid1,null);
        ImageView im= (ImageView) view.findViewById(R.id.imageView);
        ImageView im2= (ImageView) view.findViewById(R.id.w2);
        ImageView im3= (ImageView) view.findViewById(R.id.w3);

        im.setImageResource(pa[position]);
        switch (position){
            case 0:
                im2.setVisibility(View.VISIBLE);
                im2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent();
                    }
                });
                ;break;
            case 1:
                im2.setVisibility(View.VISIBLE);
                im2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent();
                    }
                });
                ;break;
            case 2:
                im3.setVisibility(View.VISIBLE);
                im3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent();
                    }
                });
                ;break;
        }
        container.addView(view);
        return view;
    }
    public void  intent(){
        Intent Intent=new Intent(context, Main3Activity.class);
        context.startActivity(Intent);
    }
}
