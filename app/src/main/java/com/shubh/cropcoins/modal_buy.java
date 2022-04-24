package com.shubh.cropcoins;

public class modal_buy {

    String Item , Load , Minbid , Seller , key ,  Original;

   public modal_buy(){}


    public modal_buy(String item, String load, String minbid, String seller ,String original) {
        this.Item = item;
        this.Load = load;
        this.Minbid = minbid;
        this.Seller = seller;
        this.Original = original;
    }

    public modal_buy(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getLoad() {
        return Load;
    }

    public void setLoad(String load) {
        Load = load;
    }

    public String getMinbid() {
        return Minbid;
    }

    public void setMinbid(String minbid) {
        Minbid = minbid;
    }

    public String getSeller() {
        return Seller;
    }

    public void setSeller(String seller) {
        Seller = seller;
    }

    public String getOriginal() {
        return Original;
    }

    public void setOriginal(String original) {
        Original = original;
    }
}
