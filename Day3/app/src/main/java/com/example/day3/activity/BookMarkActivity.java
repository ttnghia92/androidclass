package com.example.day3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.day3.R;
import com.example.day3.database.AppDatabase;
import com.example.day3.database.BookmarkEntity;

import java.util.List;

public class BookMarkActivity extends AppCompatActivity {

    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mark);
        db = AppDatabase.getDatabase(this);
        insertBookMark();
    }
    private void insertBookMark(){
        BookmarkEntity bm = new BookmarkEntity();
        bm.title = "This is title";
        bm.content = "This is content";
        db.bookmarkDao().insertBookmart(bm);
    }
    private void updateBookMark(int id){
        BookmarkEntity bm = db.bookmarkDao().getBookMark(id);
        bm.title = "This is title";
        db.bookmarkDao().updateBookmark(bm);
    }
    private void findBookmark(int id){
        BookmarkEntity bm = db.bookmarkDao().getBookMark(id);
        Log.d("TAG", "findBookmark with id: " + id + " title: " + bm.title);
    }
    private void deleteBookMark(int id){
        BookmarkEntity bm = db.bookmarkDao().getBookMark(id);
        db.bookmarkDao().deleteBookmark(bm);
    }
    private void deleteAllBookMark(){
        db.bookmarkDao().deleteAll();
    }
    private void getAllBookMark(){
       List<BookmarkEntity> list = db.bookmarkDao().getAllBookMark();
       for(BookmarkEntity item : list){
           Log.d("TAG", "findBookmark with id: " + item.id + " title: " + item.title);
       }
    }
}