package com.shubh.cropcoins;

public class modal_pybuy {

    String Buyer ,Bid;



    modal_pybuy(){}


    public modal_pybuy(String buyer, String bid) {
        Buyer = buyer;
        Bid = bid;
    }

    public String getBuyer() {
        return Buyer;
    }

    public void setBuyer(String buyer) {
        Buyer = buyer;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }
}
