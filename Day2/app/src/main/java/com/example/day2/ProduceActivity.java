package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ProduceActivity extends AppCompatActivity {
    private List<Product> listProduct = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce);

        initData();
        ProductAdapter adapter = new ProductAdapter(this,listProduct);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        RecyclerView rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);

    }
    private void initData(){
        listProduct.add(new Product("Product 1","150000",R.drawable.p1));
        listProduct.add(new Product("Product 2","250000",R.drawable.p2));
        listProduct.add(new Product("Product 3","350000",R.drawable.p3));
        listProduct.add(new Product("Product 4","450000",R.drawable.p4));
        listProduct.add(new Product("Product 5","550000",R.drawable.p5));
        listProduct.add(new Product("Product 6","650000",R.drawable.p6));
    }
}