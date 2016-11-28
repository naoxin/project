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

public class Home_aojiao_adapter extends BaseAdapter {
    List<Pager_Vp.DataBean.TagBean> aojiao;
    Context Context;
    String jia = "http://image1.suning.cn";
    ImageLoader loader = ImageLoader.getInstance();

    public Home_aojiao_adapter(List<Pager_Vp.DataBean.TagBean> aojiao, android.content.Context context) {
        this.aojiao = aojiao;
        Context = context;
    }

    @Override
    public int getCount() {
        return aojiao.size();
    }

    @Override
    public Object getItem(int i) {
        return aojiao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = View.inflate(Context, R.layout.mylist_aojiao, null);
        ImageView aojiao_im = (ImageView) view.findViewById(R.id.aojiao_im);
        loader.displayImage(jia + aojiao.get(i).getPicUrl(), aojiao_im);
        aojiao_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context.startActivity(new Intent(Context, WebviewActivity.class).putExtra("path", aojiao.get(i).getLinkUrl()));
            }
        });
        return view;
    }
}
