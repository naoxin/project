package com.hhzmy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.bean.Pager_Vp;
import com.hhzmy.hhzmy.WebviewActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by asus on 2016/11/14.
 */
public class Home_VP_Adapter extends PagerAdapter{
    String jia="http://image1.suning.cn";
    List<Pager_Vp.DataBean.TagBean> ta;
    Context context;

    public Home_VP_Adapter(List<Pager_Vp.DataBean.TagBean> ta, Context context) {
        this.ta = ta;
        this.context = context;
    }

    public int getCount() {
        return ta.size();
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
    public Object instantiateItem(ViewGroup container, final int position) {
        View view=View.inflate(context, R.layout.pager_viewpager1,null);
        ImageView im= (ImageView) view.findViewById(R.id.pager_viewpaIm);
        ImageLoader.getInstance().displayImage(jia+ta.get(position).getPicUrl(),im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,WebviewActivity.class).putExtra("path",ta.get(position).getLinkUrl()));
            }
        });
        container.addView(view);
        return view;
    }
}
