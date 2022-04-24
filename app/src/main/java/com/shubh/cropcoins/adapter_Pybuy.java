package com.shubh.cropcoins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class adapter_Pybuy extends RecyclerView.Adapter<adapter_Pybuy.PyHolder> {


    ArrayList<modal_pybuy> list;
    Context context;

    public adapter_Pybuy(ArrayList<modal_pybuy> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_pybuy,parent,false);
        return new PyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PyHolder holder, int position) {

        modal_pybuy adp = list.get(position);

        holder.Buyer.setText(adp.getBuyer());
        holder.Bid.setText(adp.getBid());





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PyHolder extends RecyclerView.ViewHolder

    {
        TextView Buyer , Bid;

        public PyHolder(@NonNull View itemView) {
            super(itemView);

            Buyer = itemView.findViewById(R.id.Buyer_py);
            Bid = itemView.findViewById(R.id.coins_py);


        }
    }


}
