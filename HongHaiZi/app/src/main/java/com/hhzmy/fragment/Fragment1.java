package com.hhzmy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.ehhzmy.hhzmy.R;
import com.google.gson.Gson;
import com.hhzmy.adapter.Home_VP_Adapter;
import com.hhzmy.adapter.Home_aojiao_adapter;
import com.hhzmy.adapter.Home_lama_adapter;
import com.hhzmy.adapter.Home_muying_adapter;
import com.hhzmy.adapter.Home_zhuti_adapter;
import com.hhzmy.adapter.Pager_ViewPager1;
import com.hhzmy.bean.Pager_Vp;
import com.hhzmy.hhzmy.SaoYiSaoActivity;
import com.hhzmy.hhzmy.ShopActivity;
import com.hhzmy.util.OkHttp;
import com.hhzmy.view.MyGridView;
import com.hhzmy.view.MyListView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by liyan on 2016/11/8.
 */

public class Fragment1 extends Fragment {

    String path = "http://mock.eoapi.cn/success/jSWAxchCQfuhI6SDlIgBKYbawjM3QIga";
    String jia = "http://image1.suning.cn";
    private ViewPager vp;
    private Pager_Vp page;
    Home_VP_Adapter adapter;
    private View view;
    private GridView home_fra_gv;
    Pager_ViewPager1 gridadapter;
    private ImageView fra_im;
    private ImageView hor_home_im1;
    private ImageView hor_home_im2;
    private ImageView hor_home_im3;
    private ImageView hor_home_im4;
    private ImageView hor_home_im5;
    private ImageView hor_home_im6;
    private ImageView home_ping;
    private ImageView home_zs;
    ImageLoader loader = ImageLoader.getInstance();
    private ImageView home_zs_yun1;
    private ImageView home_zs_yun2;
    private ImageView home_zhu;
    private MyListView mylv;
    private ImageView home_lama;
    private MyListView lama;
    private ImageView home_gengduo;
    private ImageView sao;
    private MyGridView home_aojiao;
    private MyGridView home_muying;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment1, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        qing();
        kongjian();
    }

    public void qing() {
        OkHttp.getAsync(path, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                page = gson.fromJson(result, Pager_Vp.class);
//ViewPager
                List<Pager_Vp.DataBean.TagBean> ta = page.getData().get(0).getTag();
                adapter = new Home_VP_Adapter(ta, getActivity());
                vp.setAdapter(adapter);
//签到GridView
                List<Pager_Vp.DataBean.TagBean> ta1 = page.getData().get(1).getTag();
                gridadapter = new Pager_ViewPager1(ta1, getActivity());
                home_fra_gv.setAdapter(gridadapter);
//十点秒杀
                List<Pager_Vp.DataBean.TagBean> ta2 = page.getData().get(2).getTag();
                loader.displayImage(jia + ta2.get(0).getPicUrl(), fra_im);
                loader.displayImage(jia + ta2.get(1).getPicUrl(), hor_home_im1);
                loader.displayImage(jia + ta2.get(2).getPicUrl(), hor_home_im2);
                loader.displayImage(jia + ta2.get(3).getPicUrl(), hor_home_im3);
                loader.displayImage(jia + ta2.get(4).getPicUrl(), hor_home_im4);
                loader.displayImage(jia + ta2.get(5).getPicUrl(), hor_home_im5);
                loader.displayImage(jia + ta2.get(6).getPicUrl(), hor_home_im6);
//傲娇品牌
                List<Pager_Vp.DataBean.TagBean> ta4 = page.getData().get(4).getTag();
                loader.displayImage(jia + ta4.get(0).getPicUrl(), home_ping);

                final List<Pager_Vp.DataBean.TagBean> aojiao = new ArrayList<>();
                aojiao.addAll(page.getData().get(5).getTag());
                aojiao.addAll(page.getData().get(6).getTag());
                aojiao.addAll(page.getData().get(7).getTag());
                home_aojiao.setAdapter(new Home_aojiao_adapter(aojiao, getActivity()));
                List<Pager_Vp.DataBean.TagBean> ta9 = page.getData().get(9).getTag();
                loader.displayImage(jia + ta9.get(0).getPicUrl(), home_zs);
//母婴专卖
                List<Pager_Vp.DataBean.TagBean> ta10 = page.getData().get(10).getTag();
                loader.displayImage(jia + ta10.get(0).getPicUrl(), home_zs_yun1);
                loader.displayImage(jia + ta10.get(1).getPicUrl(), home_zs_yun2);

                List<Pager_Vp.DataBean.TagBean> ta11 = page.getData().get(11).getTag();
                home_muying.setAdapter(new Home_muying_adapter(ta11, getActivity()));
//主题特卖
                List<Pager_Vp.DataBean.TagBean> ta13 = page.getData().get(13).getTag();
                loader.displayImage(jia + ta13.get(0).getPicUrl(), home_zhu);

                List<Pager_Vp.DataBean.TagBean> mTagBean = new ArrayList<>();
                List<Pager_Vp.DataBean> mDataBean = new ArrayList<>();
                mTagBean.addAll(page.getData().get(14).getTag());
                mTagBean.addAll(page.getData().get(16).getTag());
                mTagBean.addAll(page.getData().get(18).getTag());
                mTagBean.addAll(page.getData().get(20).getTag());
                mDataBean.add(page.getData().get(15));
                mDataBean.add(page.getData().get(17));
                mDataBean.add(page.getData().get(19));
                mDataBean.add(page.getData().get(21));
                mylv.setAdapter(new Home_zhuti_adapter(mTagBean, mDataBean, getActivity()));
//辣妈拼团
                List<Pager_Vp.DataBean.TagBean> ta23 = page.getData().get(23).getTag();
                loader.displayImage(jia + ta23.get(0).getPicUrl(), home_lama);

                List<Pager_Vp.DataBean.TagBean> tag = new ArrayList<>();
                tag.addAll(page.getData().get(24).getTag());
                tag.addAll(page.getData().get(26).getTag());
                tag.addAll(page.getData().get(28).getTag());
                tag.addAll(page.getData().get(30).getTag());
                tag.addAll(page.getData().get(32).getTag());
                lama.setAdapter(new Home_lama_adapter(tag, getActivity()));

                List<Pager_Vp.DataBean.TagBean> ta33 = page.getData().get(33).getTag();
                loader.displayImage(jia + ta33.get(0).getPicUrl(), home_gengduo);
            }
        });
    }

    public void kongjian() {
        vp = (ViewPager) view.findViewById(R.id.fra_vp);
        home_fra_gv = (GridView) view.findViewById(R.id.home_fra_gv);
        fra_im = (ImageView) view.findViewById(R.id.fra_im);
        hor_home_im1 = (ImageView) view.findViewById(R.id.hor_home_im1);
        hor_home_im2 = (ImageView) view.findViewById(R.id.hor_home_im2);
        hor_home_im3 = (ImageView) view.findViewById(R.id.hor_home_im3);
        hor_home_im4 = (ImageView) view.findViewById(R.id.hor_home_im4);
        hor_home_im5 = (ImageView) view.findViewById(R.id.hor_home_im5);
        hor_home_im6 = (ImageView) view.findViewById(R.id.hor_home_im6);
        home_ping = (ImageView) view.findViewById(R.id.home_ping);
        home_aojiao = (MyGridView) view.findViewById(R.id.home_aojiao);
        home_zs = (ImageView) view.findViewById(R.id.home_zs);
        home_zs_yun1 = (ImageView) view.findViewById(R.id.home_zs_yun1);
        home_zs_yun2 = (ImageView) view.findViewById(R.id.home_zs_yun2);
        home_muying = (MyGridView) view.findViewById(R.id.home_muying);
        home_zhu = (ImageView) view.findViewById(R.id.home_zhu);
        mylv = (MyListView) view.findViewById(R.id.hp_home_lv1);
        home_lama = (ImageView) view.findViewById(R.id.home_lama);
        lama = (MyListView) view.findViewById(R.id.hp_home_lama);
        home_gengduo = (ImageView) view.findViewById(R.id.home_gengduo);
        hor_home_im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
            }
        });
        hor_home_im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
            }
        });
        hor_home_im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
            }
        });
        hor_home_im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
            }
        });
        hor_home_im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
            }
        });
        sao = (ImageView) view.findViewById(R.id.sao);
        sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SaoYiSaoActivity.class);
                startActivity(intent);
            }
        });
    }
}
