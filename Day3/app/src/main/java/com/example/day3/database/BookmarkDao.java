package com.example.day3.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface BookmarkDao {
    @Insert(onConflict = REPLACE)
    void insertBookmart(BookmarkEntity bookmark);
    @Update
    void updateBookmark(BookmarkEntity bookmark);
    @Delete
    void deleteBookmark(BookmarkEntity bookmark);
    @Query("SELECT * FROM Bookmark")
    List<BookmarkEntity> getAllBookMark();
    @Query("SELECT * FROM Bookmark WHERE id = :id")
    BookmarkEntity getBookMark(int id);
    @Query("DELETE FROM Bookmark")
    void deleteAll();
}
