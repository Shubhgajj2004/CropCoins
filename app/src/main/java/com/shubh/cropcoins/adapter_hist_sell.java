package com.shubh.cropcoins;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter_hist_sell extends RecyclerView.Adapter<adapter_hist_sell.HistSellHolder> {



    @NonNull
    @Override
    public HistSellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HistSellHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HistSellHolder extends RecyclerView.ViewHolder{


    TextView Type , min , state;
    public HistSellHolder(@NonNull View itemView) {
        super(itemView);

        Type = itemView.findViewById(R.id.Type_sample);
        min = itemView.findViewById(R.id.bid_sample);
        state = itemView.findViewById(R.id.state_sample);


    }
}

}
