package com.example.day3;

import com.example.day3.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManager {
    String SERVICE_URL = "https://api-demo-anhth.herokuapp.com/";

    @GET("data.json")
    Call<Item> getItemData();

    @GET("datas.json")
    Call<List<Item>> getListData();
}
