package com.example.hellonotice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ScrapActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Post> data;
    ScrapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap);
        init();
        addListener();
    }
    private void addListener() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ScrapActivity.this, PostActivity.class);
                intent.putExtra("post", data.get(position));
                startActivity(intent);
            }
        });
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new Post("공지1 제목", "공지1 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척"));
        data.add(new Post("공지2 제목", "공지2 내용입니다. 아웃백 먹고싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다", true));
        data.add(new Post("공지3 제목", "공지3 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 크림떡볶이 먹고싶다"));
        data.add(new Post("공지4 제목", "공지4 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 양념막창 먹고싶다"));
        data.add(new Post("공지5 제목", "공지5 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 소곱창 먹고싶다"));
        adapter = new ScrapAdapter(getApplicationContext(), R.layout.scrap_item, data);

        list = findViewById(R.id.scrap_list);
        list.setAdapter(adapter);
    }
}
