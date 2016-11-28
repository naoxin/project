package com.hhzmy.bean;

/**
 * Created by ${李泰亲} on 2016/11/17.
 */

public class CarData {
    private String GoodName;
    private String GoodCL;
    private double NowPrice;
    private double OriginalPrice;

    public CarData() {
    }

    public CarData(String goodName, String goodCL, double nowPrice, double originalPrice) {
        GoodName = goodName;
        GoodCL = goodCL;
        NowPrice = nowPrice;
        OriginalPrice = originalPrice;
    }

    public String getGoodCL() {
        return GoodCL;
    }

    public void setGoodCL(String goodCL) {
        GoodCL = goodCL;
    }

    public String getGoodName() {
        return GoodName;
    }

    public void setGoodName(String goodName) {
        GoodName = goodName;
    }

    public double getNowPrice() {
        return NowPrice;
    }

    public void setNowPrice(double nowPrice) {
        NowPrice = nowPrice;
    }

    public double getOriginalPrice() {
        return OriginalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        OriginalPrice = originalPrice;
    }
}
