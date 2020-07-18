package com.example.day4;

import com.example.day4.model.login.LoginParam;
import com.example.day4.model.login.LoginReponse;
import com.example.day4.model.news.news;
import com.example.day4.model.news.newsreponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIManager {
    String SERVICE_URL = "https://reqres.in";
    String SERVICE_NEWS_URL = "http://newsapi.org";
    String sources="google-news";
    String apiKey="c866af9fb43043818d5940c999c614b5";

    @POST("/api/login")
    Call<LoginReponse> postLogin(@Body LoginParam loginParam);

    @GET("/v2/top-headlines")
    Call<newsreponse> getListData(@Query("sources") String source, @Query("apiKey") String apikey);
}
