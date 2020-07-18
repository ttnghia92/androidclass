package com.example.day4.model.news;

import java.util.List;

public class newsreponse {
    private String status;
    private String totalResults;
    private List<news> articles;

    public newsreponse(String status, String totalResults, List<news> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<news> getArticles() {
        return articles;
    }

    public void setArticles(List<news> articles) {
        this.articles = articles;
    }
}
