package com.hhzmy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.bean.Pager_Vp;
import com.hhzmy.hhzmy.ShopActivity;
import com.hhzmy.hhzmy.WebviewActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by liyan on 2016/11/15.
 */

public class Home_zhuti_adapter extends BaseAdapter {
    List<Pager_Vp.DataBean.TagBean> mTagBean;
    List<Pager_Vp.DataBean> mDataBean ;
    Context Context;
    String jia="http://image1.suning.cn";
    ImageLoader loader=ImageLoader.getInstance();

    public Home_zhuti_adapter(List<Pager_Vp.DataBean.TagBean> mTagBean, List<Pager_Vp.DataBean> mDataBean, android.content.Context context) {
        this.mTagBean = mTagBean;
        this.mDataBean = mDataBean;
        Context = context;
    }

    @Override
    public int getCount() {
        return mTagBean.size();
    }

    @Override
    public Object getItem(int i) {
        return mTagBean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final  int i, View view, ViewGroup viewGroup) {
        view=View.inflate(Context, R.layout.mylist_zhuti,null);
        ImageView im= (ImageView) view.findViewById(R.id.zhuti_im);
        ImageView im1= (ImageView) view.findViewById(R.id.zhuti_im_ho1);
        ImageView im2= (ImageView) view.findViewById(R.id.zhuti_im_ho2);
        ImageView im3= (ImageView) view.findViewById(R.id.zhuti_im_ho3);
        ImageView im4= (ImageView) view.findViewById(R.id.zhuti_im_ho4);
        ImageView im5= (ImageView) view.findViewById(R.id.zhuti_im_ho5);
        ImageView im6= (ImageView) view.findViewById(R.id.zhuti_im_ho6);
        loader.displayImage(jia+mTagBean.get(i).getPicUrl(),im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context,WebviewActivity.class).putExtra("path",mTagBean.get(i).getLinkUrl()));
            }
        });
       final List<Pager_Vp.DataBean.TagBean> mTagBean1 = mDataBean.get(i).getTag();
        loader.displayImage(jia+mTagBean1.get(0).getPicUrl(),im1);
        loader.displayImage(jia+mTagBean1.get(1).getPicUrl(),im2);
        loader.displayImage(jia+mTagBean1.get(2).getPicUrl(),im3);
        loader.displayImage(jia+mTagBean1.get(3).getPicUrl(),im4);
        loader.displayImage(jia+mTagBean1.get(4).getPicUrl(),im5);
        loader.displayImage(jia+mTagBean1.get(5).getPicUrl(),im6);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context,ShopActivity.class).putExtra("path",mTagBean1.get(0).getLinkUrl()));
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context,ShopActivity.class).putExtra("path",mTagBean1.get(1).getLinkUrl()));
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context,ShopActivity.class).putExtra("path",mTagBean1.get(2).getLinkUrl()));
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context,ShopActivity.class).putExtra("path",mTagBean1.get(3).getLinkUrl()));
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context,ShopActivity.class).putExtra("path",mTagBean1.get(4).getLinkUrl()));
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context,ShopActivity.class).putExtra("path",mTagBean1.get(5).getLinkUrl()));
            }
        });

        return view;
    }
}
