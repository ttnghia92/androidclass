package com.example.day4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day4.APIManager;
import com.example.day4.R;
import com.example.day4.adapter.NewsAdapter;
import com.example.day4.interfaces.NewsOnClick;
import com.example.day4.model.news.news;
import com.example.day4.model.news.newsreponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNewsActivity extends AppCompatActivity {
    RecyclerView rvListNews;
    List<news> listData;
    newsreponse newlist;
    NewsAdapter adapter;
    TextView tvidUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        getListData();
        listData = new ArrayList<>();
        adapter = new NewsAdapter(ListNewsActivity.this,listData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvListNews = findViewById(R.id.rvListNews);
        rvListNews.setLayoutManager(layoutManager);
        rvListNews.setAdapter(adapter);

        Intent intent = getIntent();
        String user = intent.getStringExtra("USER");
        String token = intent.getStringExtra("TOKEN");
        tvidUser = findViewById(R.id.tviduser);
        tvidUser.setText(user);
        adapter.setiOnClick(new NewsOnClick() {
            @Override
            public void onClickItem(int position) {
                news model = listData.get(position);
                Toast.makeText(ListNewsActivity.this,model.getAuthor(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getListData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVICE_NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager service = retrofit.create(APIManager.class);
        service.getListData(APIManager.sources,APIManager.apiKey).enqueue(new Callback<newsreponse>() {
            @Override
            public void onResponse(Call<newsreponse> call, Response<newsreponse> response) {
                if(response.body()!=null){
                    newlist = response.body();
                    listData = newlist.getArticles();
                    adapter.reloadData(listData);
                }
            }

            @Override
            public void onFailure(Call<newsreponse> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t);
            }
        });
    }
}