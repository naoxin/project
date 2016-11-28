package com.hhzmy.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.ehhzmy.hhzmy.R;
import com.google.gson.Gson;
import com.hhzmy.bean.CarData;
import com.hhzmy.bean.ShopCarDataBean;
import com.hhzmy.pay.AuthResult;
import com.hhzmy.pay.PayResult;
import com.hhzmy.util.OkHttp;
import com.hhzmy.util.OrderInfoUtil2_0;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import okhttp3.Request;


/**
 * Created by liyan on 2016/11/8.
 */

public class Fragment3 extends Fragment implements View.OnClickListener{


    private ListView shop_lv_view;
    private   CheckBox checkall;
    private TextView shop_editbutton;
    private RelativeLayout rela_allprice;
    private Button shop_bayall;
    private String shop_bayall_text;
    private String shop_editbutton_text;
    private TextView allprice;
    private String json;
    private double sum = 0.00;
    private shop_lv_adapter adapter;
    private List<CarData> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.activity_shop_car,null);
        //获取控件ID
        getCarData();
shop_lv_view=(ListView) view.findViewById(R.id.shop_lv_view);
        checkall=(CheckBox) view.findViewById(R.id.checkall);
shop_editbutton=(TextView) view.findViewById(R.id.shop_editbutton);
        rela_allprice=(RelativeLayout)view.findViewById(R.id.rela_allprice);
        shop_bayall=(Button)view.findViewById(R.id.shop_bayall);
        allprice=(TextView)view.findViewById(R.id.allprice);
        checkall.setOnClickListener(this);
        shop_editbutton.setOnClickListener(this);
        shop_bayall.setOnClickListener(this);
        return view;
    }



    /** 支付宝支付业务：入参app_id */
    public static final String APPID = "2088901305856832";

    /** 支付宝账户登录授权业务：入参pid值 */
    public static final String PID = "8@qdbaiu.com";
    /** 支付宝账户登录授权业务：入参target_id值 */
    public static final String TARGET_ID = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCd6rV3vOE578e6VlGEakZpPdsX2QmGdIfi/yHe cg1CIEWzX9wn2LNFGtu1EzYQyKACG/RKeog0pUJEVGfBG30zFdNY2YocYJNdPtADqhJbS0GJm7f8 1vRiLKtOwKjdiz9oMEwxhc/5fysfMbercidRmlCDPU9BNL1UPb9bAx25JwIDAQAB";

    /** 商户私钥，pkcs8格式 */
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM/KCxg/OIj6er2GEig0DOkHqBSzEPHGigMbTXP1k2nrxEHeE59xOOuyovQH/A1LgbuVKyOac3uAN4GXIBEoozRVzDhu5dobeNm48BPcpYSAfvN3K/5GLacvJeENqsiBx8KufM/9inlHaDRQV7WhX1Oe2ckat1EkdHwxxQgc36NhAgMBAAECgYEAwn3sWpq6cUR65LD8h9MIjopTImTlpFjgz72bhsHDZK6A+eJDXcddrwh7DI34t/0IBqu+QEoOc/f0fIEXS9hMwTvFY59XG7M8M6SdeaAbemrGmZ1IdD6YDmpbQFHn2ishaYF0YDZIkBS3WLDFrtk/efaarBCpGAVXeEiVQE4LewECQQD5W1rpkq+dHDRzzdtdi1bJ479wun5CfmVDVb2CJH7Iz0t8zyp/iEVV2QELnxZMphmoSzKaLXutTTj2OImpzCtRAkEA1VMxG6nQq9NkU51H1+I3mlUXRZ0XeFA1GFJ7xWpNRAVhEWlDz2zy9v/gX+RFpNC3f5uznycas70Xp78ew43TEQJAZFFqi9mlqTF1sLk67bFnIyXrGPEOZrXvC13tNfR0xVkQZ4/46wHp0xXQo9pG4GNaoyhNnVV7EkelCPnJ+HPZYQJAQh6T9QgQZoGR8hyovPAf3dUL7oa/VIo/urcuJ8VIB5JHQNdIrk0NjaNHj1E4iNosVgATj3vWWel9IIArb99QkQJAKvfm78lwnImtg5IM604hdn/Wu1XF8tpxsKLWcnfchMr0bM9rCmKmhAY+wdmqSyPZRiNb1QaaaDTqJxLy6AnQ+Q==\n";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(getActivity(), "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(getActivity(), "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(getActivity(),
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(getActivity(),
                                "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
                default:
                    break;
            }
        };
    };







    //请求数据
    public void getCarData() {
        OkHttp.getAsync("http://mock.eoapi.cn/success/megQ2CBFAeFzJzIwTSVdNnpQYZCrsrIq", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                json = result;
                //Toast.makeText(ShopCarActivity.this, json + "", Toast.LENGTH_SHORT).show();
                showData(json);
            }
        });
    }

    //展示数据
    public void showData(String json) {
        //Toast.makeText(ShopCarActivity.this, json + "", Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
        ShopCarDataBean shopping = gson.fromJson(json, ShopCarDataBean.class);
        //商品型号
        List<ShopCarDataBean.DataBeanX.Data1Bean.DataBean.ItemClusterDisplayVOBean.ColorListBean> cl = shopping.getData().getData1().getData().getItemClusterDisplayVO().getColorList();
        //商品名称
        ShopCarDataBean.DataBeanX.Data1Bean.DataBean.ItemInfoVoBean name = shopping.getData().getData1().getData().getItemInfoVo();

        //价格
        ShopCarDataBean.DataBeanX.PriceBean.SaleInfoBean jia = shopping.getData().getPrice().getSaleInfo().get(0);
        //jia1.setText(jia.getNetPrice());现价
        //jia2.setText(jia.getRefPrice());原价
        list = new ArrayList<>();
        CarData cardata = new CarData();
        cardata.setGoodName(name.getItemName() + "");
        cardata.setNowPrice(Double.parseDouble(jia.getNetPrice()));
        cardata.setOriginalPrice(Double.parseDouble(jia.getRefPrice()));
        cardata.setGoodCL(cl.get(0).getCharacterValueName() + "");
        list.add(cardata);
        //Toast.makeText(ShopCarActivity.this, list.get(0).getNowPrice() + "", Toast.LENGTH_SHORT).show();
        adapter = new shop_lv_adapter(getActivity(), list);
        shop_lv_view.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkall:
                boolean flag = checkall.isChecked();
                double f1 = 0;
                for (int i = 0; i < adapter.getSelect().size(); i++) {
                    adapter.getSelect().set(i, flag);
                }
                if (flag == true) {
                    for (int i = 0; i < list.size(); i++) {
                        if (i == 0) {
                            sum = 0.00;
                        }
                        sum = sum + (list.get(i).getNowPrice()) * 1;
                        BigDecimal b1 = new BigDecimal(Double.toString(sum));
                        BigDecimal b2 = new BigDecimal(Double.toString(1));
                        f1 = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    }
                    allprice.setText("总计:￥" + f1);
                } else if (flag == false) {
                    sum = 0.00;
                    allprice.setText("总计:￥" + sum);
                }
                // shop_lv_view.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                break;
            case R.id.shop_editbutton:
                shop_editbutton_text = shop_editbutton.getText().toString();
                shop_bayall_text = shop_bayall.getText().toString();
                if (shop_editbutton_text.equals("编辑")) {
                    shop_editbutton.setText("完成");
                    rela_allprice.setVisibility(View.GONE);
                    if (shop_bayall_text.equals("结算")) {
                        shop_bayall.setText("删除");
                    }
                } else if (shop_editbutton_text.equals("完成")) {
                    shop_editbutton.setText("编辑");
                    rela_allprice.setVisibility(View.VISIBLE);
                    if (shop_bayall_text.equals("删除")) {
                        shop_bayall.setText("结算");
                    }
                }
                break;
            case R.id.shop_bayall:
                shop_bayall_text = shop_bayall.getText().toString();
                if (shop_bayall_text.equals("删除")) {
                    /*for (int i = 0; i < list.size(); i++) {
                        sum = sum - (list.get(i).getNowPrice());
                        shop_lv_view.setAdapter(new shop_lv_adapter(ShopCarActivity.this, null));
                        adapter.notifyDataSetChanged();
                    }
                    allprice.setText("总计:￥" + sum);*/
                    Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                } else if (shop_bayall_text.equals("结算")) {
                    Toast.makeText(getActivity(), "准备结算", Toast.LENGTH_SHORT).show();

                    if (TextUtils.isEmpty(APPID) || TextUtils.isEmpty(RSA_PRIVATE)) {
                        new AlertDialog.Builder(getActivity()).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialoginterface, int i) {
                                        //
                                        getActivity().finish();
                                    }
                                }).show();
                        return;
                    }

                    /**
                     * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
                     * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
                     * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
                     *
                     * orderInfo的获取必须来自服务端；
                     */
                    Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID);
                    String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
                    String sign = OrderInfoUtil2_0.getSign(params, RSA_PRIVATE);
                    final String orderInfo = orderParam + "&" + sign;

                    Runnable payRunnable = new Runnable() {

                        @Override
                        public void run() {
                            PayTask alipay = new PayTask(getActivity());
                            Map<String, String> result = alipay.payV2(orderInfo, true);
                            Log.i("msp", result.toString());

                            Message msg = new Message();
                            msg.what = SDK_PAY_FLAG;
                            msg.obj = result;
                            mHandler.sendMessage(msg);
                        }
                    };

                    Thread payThread = new Thread(payRunnable);
                    payThread.start();



//                    Intent intent = new Intent(ShopCarActivity.this, H5PayDemoActivity.class);
//                    startActivity(intent);
                }
                break;
        }

    }


    class shop_lv_adapter extends BaseAdapter {
        private Context context;
        private List<CarData> list;
        private LinkedList<Boolean> linkedList = new LinkedList<Boolean>();

        public shop_lv_adapter(Context context, List<CarData> list) {
            super();
            this.context = context;
            this.list = list;
            // 初始化
            for (int i = 0; i < list.size(); i++) {
                getSelect().add(false);
            }
        }

        public  List<Boolean> getSelect() {
            return linkedList;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final shop_lv_adapter.ViewHolder vh;
            if (convertView == null) {
                convertView = convertView.inflate(context, R.layout.shop_lv_item, null);
                vh = new shop_lv_adapter.ViewHolder();
                vh.shop_checkbox = (CheckBox) convertView.findViewById(R.id.shop_checkbox);
                vh.shop_goodimg = (ImageView) convertView.findViewById(R.id.shop_goodimg);
                vh.shop_goodname = (TextView) convertView.findViewById(R.id.shop_goodname);
                vh.shop_price = (TextView) convertView.findViewById(R.id.shop_price);
                vh.shop_count = (TextView) convertView.findViewById(R.id.shop_count);
                convertView.setTag(vh);
            } else {
                vh = (shop_lv_adapter.ViewHolder) convertView.getTag();
            }
            vh.shop_goodname.setText(list.get(position).getGoodName() + "");
            vh.shop_count.setText("数量:1");
            vh.shop_price.setText("现价:￥" + list.get(position).getNowPrice() + "元");

            vh.shop_checkbox.setChecked(linkedList.get(position));
            // 不能用onCheckChangedListner()复用的时候
            vh.shop_checkbox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    linkedList.set(position, !linkedList.get(position));
                    if (linkedList.contains(false)) {

                        checkall.setChecked(false);
                    } else {
                        checkall.setChecked(true);
                    }
                    if (vh.shop_checkbox.isChecked() == true) {
                        sum = sum + (list.get(position).getNowPrice());
                        //goodid_list.add(list.get(position).getGoodid());
                    } else if (vh.shop_checkbox.isChecked() == false) {
                        sum = sum - (list.get(position).getNowPrice());
                        //list.remove(list.get(position));
                    }
                    //计算
                    //BigDecimal b1 = new BigDecimal(Double.toString(sum));
                    //BigDecimal b2 = new BigDecimal(Double.toString(1));
                    //double f1 = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    allprice.setText("总计:￥" + sum);
                    // double
                    // sum=(list.get(position).getPrice())*(list.get(position).getCount());
                    // Toast.makeText(context, "点击了"+position+"的checkbox",
                    // 0).show();
                    // 刷新
                    notifyDataSetChanged();
                }
            });
            return convertView;
        }

        class ViewHolder {
            CheckBox shop_checkbox;
            ImageView shop_goodimg;
            TextView shop_goodname, shop_price, shop_count;
        }


















    }



}


