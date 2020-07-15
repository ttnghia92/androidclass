package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate: check log");
        Intent intent = getIntent();
        String text = intent.getStringExtra("KIENHANG");
        TextView txtthongbao = findViewById(R.id.tvthongbao);
        txtthongbao.setText(text);
    }
}