package com.hhzmy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.bean.Pager_Vp;
import com.hhzmy.hhzmy.WebviewActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by liyan on 2016/11/15.
 */

public class Home_lama_adapter extends BaseAdapter {
    List<Pager_Vp.DataBean.TagBean> mTagBean;
    Context Context;
    String jia="http://image1.suning.cn";
    ImageLoader loader=ImageLoader.getInstance();

    public Home_lama_adapter(List<Pager_Vp.DataBean.TagBean> mTagBean, android.content.Context context) {
        this.mTagBean = mTagBean;
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
        view=View.inflate(Context, R.layout.mylist_lama,null);
        ImageView im= (ImageView) view.findViewById(R.id.lama_im);
        loader.displayImage(jia+mTagBean.get(i).getPicUrl(),im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Context.startActivity(new Intent(Context,WebviewActivity.class).putExtra("path",mTagBean.get(i).getLinkUrl()));
            }
        });



        return view;
    }
}
