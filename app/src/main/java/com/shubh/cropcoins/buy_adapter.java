package com.shubh.cropcoins;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class buy_adapter extends RecyclerView.Adapter<buy_adapter.BuyHolder> {

ArrayList<modal_buy> list;
Context context;
ArrayList<modal_buy> listkey;

    public buy_adapter(ArrayList<modal_buy> list, Context context, ArrayList<modal_buy> listkey) {
        this.list = list;
        this.context = context;
        this.listkey = listkey;
    }

    @NonNull
    @Override
    public BuyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_buy,parent,false);
        return new BuyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyHolder holder, int position) {

        modal_buy adp = list.get(position);
        modal_buy adp2 = listkey.get(position);

        holder.type.setText(adp.getItem());
        holder.seller.setText(adp.getSeller());
        holder.coins.setText(adp.getMinbid());
        holder.amount.setText(adp.getLoad()+"Kg");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , Detail_buy.class);
                intent.putExtra("type" , adp.getItem());
                intent.putExtra("seller" , adp.getSeller());
                intent.putExtra("coins" , adp.getMinbid());
                intent.putExtra("amount" , adp.getLoad());
                intent.putExtra("key" , adp2.getKey());
                intent.putExtra("original" , adp.getOriginal());
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BuyHolder extends RecyclerView.ViewHolder{

        TextView type , seller , coins , amount;
        public BuyHolder(@NonNull View itemView) {
            super(itemView);

            type = itemView.findViewById(R.id.Type_sample);
            seller = itemView.findViewById(R.id.Seller_sample);
            coins = itemView.findViewById(R.id.coins_sample);
            amount = itemView.findViewById(R.id.Amount_sample);
        }
    }
}
