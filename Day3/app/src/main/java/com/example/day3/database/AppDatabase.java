package com.example.day3.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {BookmarkEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public abstract BookmarkDao bookmarkDao();

    public static AppDatabase getDatabase(Context context){
        if(appDatabase==null){
            appDatabase= Room.databaseBuilder(context,AppDatabase.class,"News").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
