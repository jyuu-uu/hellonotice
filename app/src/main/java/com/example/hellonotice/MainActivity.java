package com.example.hellonotice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView btn1, btn2;
    ListView list1, list2;
    MainAdapter adapter;
    ArrayList<Post> data;
    TextView t1, t2;
    Intent getfromadd;
    String category1, category2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        getfromadd = getIntent();
        if (getfromadd != null) {
            category2 = getfromadd.getStringExtra("category");
        }
        init();
        addListener();
    }

    private void addListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrapActivity.class);
                startActivity(intent);
            }
        });
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                intent.putExtra("post", data.get(position));
                startActivity(intent);
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        btn1 = findViewById(R.id.searchBtn);
        btn2 = findViewById(R.id.scrapBtn);
        list1 = findViewById(R.id.list1_main);
        list2 = findViewById(R.id.list2_main);
        t1 = findViewById(R.id.main_category1);
        t2 = findViewById(R.id.main_category2);
        t2.setText(category2);

        data = new ArrayList<>();
        data.add(new Post("공지1 제목", "공지1 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척"));
        data.add(new Post("공지2 제목", "공지2 내용입니다. 아웃백 먹고싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다", true));
        data.add(new Post("공지3 제목", "공지3 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 크림떡볶이 먹고싶다"));
        data.add(new Post("공지4 제목", "어쩌구 저쩌구 대충 웹 크롤링한 척 화양156 크림떡볶이 격하게 먹고 싶다 근데 배는 안고프다 그냥 먹고 싶을 뿐이다 이서희 바보 멍청이 똥깨 화장실은 왜 막아"));
        data.add(new Post("공지5 제목", "공지5 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 크림떡볶이 먹고싶다"));
        adapter = new MainAdapter(getApplicationContext(), R.layout.main_item, data);
        list1.setAdapter(adapter);
        if (category2 != null) {
            list2.setAdapter(adapter);
        }
    }
}
