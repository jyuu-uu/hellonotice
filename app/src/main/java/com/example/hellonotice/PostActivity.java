package com.example.hellonotice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {
    Post p;
    TextView t1, t2;
    ImageButton btn;

    DatabaseReference rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Intent intent = getIntent();
        p = (Post)intent.getSerializableExtra("post");
        init();

        btn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("scrap","btn 클릭");
                if(p.isScrap()){
                    p.setScrap(false);
                    btn.setImageResource(R.drawable.scrap_btn);
                }
                else{
                    p.setScrap(true);
                    btn.setImageResource(R.drawable.scrap_btn_pink);
                }
                postFirebaseDatabase(true);
            }
        });
    }

    public void postFirebaseDatabase(boolean add){
        rdb = FirebaseDatabase.getInstance().getReference();
        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add){
            Post post = new Post(p.getTitle(), p.getContent(), p.isScrap());
            post.setId(p.getId());
            postValues = post.toMap();
        }
        childUpdates.put("/post_list/" + p.getId(), postValues);
        rdb.updateChildren(childUpdates);
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
