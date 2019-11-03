package com.example.hellonotice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class PostActivity extends AppCompatActivity {
    Post p;
    TextView t1, t2;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Intent intent = getIntent();
        p = (Post)intent.getSerializableExtra("post");
        init();
    }

    private void init() {
        t1 = findViewById(R.id.post_title);
        t2 = findViewById(R.id.post_content);
        btn = findViewById(R.id.post_scrap);
        if (p.isScrap()) {
            btn.setImageResource(R.drawable.scrap_btn_pink);
        } else {
            btn.setImageResource(R.drawable.scrap_btn);
        }
        t1.setText(p.getTitle());
        t2.setText(p.getContent());
    }
}
