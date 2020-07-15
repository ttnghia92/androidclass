package com.example.day2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Product> listproduct;

    public ProductAdapter(Activity activity, List<Product> listproduct) {
        this.activity = activity;
        this.listproduct = listproduct;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = activity.getLayoutInflater().inflate(R.layout.product_item,parent,false);
        ProductHolder holder = new ProductHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolder productHolder =  (ProductHolder) holder;
        Product modem = listproduct.get(position);
        productHolder.ivCover.setImageResource(modem.getImgage());
        productHolder.tvName.setText(modem.getName());
        productHolder.tvPrice.setText(modem.getPrive());
    }

    @Override
    public int getItemCount() {
        return listproduct.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        ImageView ivCover;
        TextView tvName;
        TextView tvPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.imgCover);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
