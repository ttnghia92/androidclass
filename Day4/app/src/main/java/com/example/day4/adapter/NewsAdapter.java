package com.example.day4.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day4.R;
import com.example.day4.interfaces.NewsOnClick;
import com.example.day4.model.news.news;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<news> listNews;
    private NewsOnClick iOnClick;

    public NewsAdapter(Activity activity, List<news> listNews) {
        this.activity = activity;
        this.listNews = listNews;
    }
    public void setiOnClick(NewsOnClick iOnClick){
        this.iOnClick = iOnClick;
    }
    public  void reloadData(List<news> listData){
        this.listNews = listData;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_news,parent,false);
        NewsHolder holder = new NewsHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsHolder hd = (NewsHolder)holder;
        news model = listNews.get(position);
        hd.tvPublishedAt.setText(model.getPublishedAt());
        hd.tvTitle.setText(model.getTitle());
        hd.tvDescription.setText(model.getDescription());
        hd.tvAuthor.setText(model.getAuthor());
        hd.tvContent.setText(model.getContent());
        Glide.with(activity).load(model.getUrlToImage()).into(hd.ivCover);
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    private class NewsHolder extends RecyclerView.ViewHolder{
        TextView tvPublishedAt,tvTitle,tvDescription,tvAuthor,tvContent;
        ImageView ivCover;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            tvPublishedAt = itemView.findViewById(R.id.tvPublishedAt);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvContent = itemView.findViewById(R.id.tvContent);
            ivCover = itemView.findViewById(R.id.ivCover);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    iOnClick.onClickItem(getAdapterPosition());
                }
            });

        }
    }
}
