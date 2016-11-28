package com.hhzmy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehhzmy.hhzmy.R;
import com.hhzmy.bean.Pager_Vp;
import com.hhzmy.hhzmy.WebviewActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by liyan on 2016/11/9.
 */

public class Pager_ViewPager1 extends BaseAdapter{
    List<Pager_Vp.DataBean.TagBean> ta1;
    Context context;

    public Pager_ViewPager1(List<Pager_Vp.DataBean.TagBean> ta1, Context context) {
        this.ta1 = ta1;
        this.context = context;
    }

    @Override
    public int getCount() {
        return ta1.size();
    }

    @Override
    public Object getItem(int i) {
        return ta1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context, R.layout.pager_gridview,null);
        TextView te= (TextView) view.findViewById(R.id.home_grid_name);
        te.setText(ta1.get(i).getElementName());
        ImageView im= (ImageView) view.findViewById(R.id.home_grid_im);
        ImageLoader.getInstance().displayImage("http://image1.suning.cn"+ta1.get(i).getPicUrl(),im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,WebviewActivity.class).putExtra("path",ta1.get(i).getLinkUrl()));
            }
        });
        return view;
    }
}
