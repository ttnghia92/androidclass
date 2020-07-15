package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_login1 extends AppCompatActivity {
    Button btn;
    TextView iduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

    }

    public void khoiTao(){
        btn = findViewById(R.id.btLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMain();
            }
        });
    }
    public void gotoMain(){
        iduser = findViewById(R.id.etuser);
        Intent intent = new Intent(activity_login1.this,MainActivity.class);
        String user = iduser.getText().toString();
        intent.putExtra("KIENHANG",user);
        startActivity(intent);
    }
}