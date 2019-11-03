//package com.example.hellonotice;
//
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//public class SearchActivity extends AppCompatActivity {
//
//    ListView list;
//    ArrayList<Post> data;
//    SearchActivityAdapter adapter;
//    String search;
//    EditText edit;
//    FirebaseDatabase db;
//    DatabaseReference rdb;
//
//    ImageView btn1, btn2;
//    ListView list1, list2;
//    TextView t1, t2;
//    Intent getfromadd;
//    String category1, category2;
//
///*
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//        init();
//        addListener();
//
//        db = FirebaseDatabase.getInstance();
//        db.setPersistenceEnabled(true);
//        rdb = db.getReference("post_list");
//        connectDB();
//
//    }
//*/
//
//
//
///*
//
//    private void addListener() {
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(SearchActivity.this, PostActivity.class);
//                intent.putExtra("post", data.get(position));
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void init() {
//        search = getIntent().getStringExtra("searchtext");
//        edit = findViewById(R.id.searched_text);
//        edit.setText(search);
//
//        data = new ArrayList<>();
//        data.add(new Post("공지1 제목", "공지1 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척"));
//        data.add(new Post("공지2 제목", "공지2 내용입니다. 아웃백 먹고싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다", true));
//        data.add(new Post("공지3 제목", "공지3 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 크림떡볶이 먹고싶다"));
//        data.add(new Post("공지4 제목", "공지4 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 양념막창 먹고싶다"));
//        data.add(new Post("공지5 제목", "공지5 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 소곱창 먹고싶다"));
//        adapter = new ListAdapter(getApplicationContext(), R.layout.list_item, data);
//
//        list = findViewById(R.id.search_list);
//        list.setAdapter(adapter);
//    }
//*/
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        db = FirebaseDatabase.getInstance();
//        //db.setPersistenceEnabled(true);
//        rdb = db.getReference("post_list");
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SearchActivity.this, AddActivity.class);
//                startActivity(intent);
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });/*
//        getfromadd = getIntent();
//        if (getfromadd != null) {
//            category2 = getfromadd.getStringExtra("category");
//        }*/
//        category1 = " ";
//        init();
//        //call friebaseauth
//        addListener();
//        connectDB();
//
//    }
//
//    private void addListener() {
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SearchActivity.this, SearchActivity.class);
//                intent.putExtra("searchtext", edit.getText().toString());
//                //Toast.makeText(getApplicationContext(), edit.getText(), Toast.LENGTH_SHORT).show();
//                startActivity(intent);
//            }
//        });
//        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(SearchActivity.this, PostActivity.class);
//                intent.putExtra("post", data.get(position));
//                startActivity(intent);
//            }
//        });
//        t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SearchActivity.this, ListActivity.class);
//                startActivity(intent);
//            }
//        });
///*        t2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SearchActivity.this, ListActivity.class);
//                startActivity(intent);
//            }
//        });*/
//    }
//
//    private void init() {
//        search = getIntent().getStringExtra("searchtext");
//        edit = findViewById(R.id.searched_text);
//        edit.setText(search);
//
//        btn1 = findViewById(R.id.searchBtn);
//        btn2 = findViewById(R.id.scrapBtn);
//        edit = findViewById(R.id.search_text);
//        list1 = findViewById(R.id.list1_main);
//        //list2 = findViewById(R.id.list2_main);
//        t1 = findViewById(R.id.main_category1);
//        //t2 = findViewById(R.id.main_category2);
//        t1.setText(category1);
//        //t2.setText(category2);
//
//        data = new ArrayList<>();
//        data.clear();
//        adapter = new SearchActivityAdapter(getApplicationContext(), R.layout.main_item, data);
//
//        list1.setAdapter(adapter);
//        //if (category2 != null) {
//        //    list2.setAdapter(adapter);
//        //}
//
//
//    }
//
//    public void connectDB() {
//
//        rdb.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String s1 = snapshot.child("title").getValue().toString();
//                    String s2 = snapshot.child("content").getValue().toString();
//                    String s3 = snapshot.child("scrap").getValue().toString();
//                    boolean b = false;
//                    if (s3.equals("true")) {
//                        b = true;
//                    } else if (s3.equals("false")) {
//                        b = false;
//                    }
//                    Post p = new Post(s1, s2, b);
//                    //Log.i("DB확인", p.getTitle());
//                    data.add(p);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
//}

//package com.example.hellonotice;
//
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//public class SearchActivity extends AppCompatActivity {
//    ListView list;
//    ArrayList<Post> data;
//    ListAdapter adapter;
//    String search;
//    EditText edit;
//    FirebaseDatabase db;
//    DatabaseReference rdb;
//
//    ImageView btn1, btn2;
//    ListView list1, list2;
//    TextView t1, t2;
//    Intent getfromadd;
//    String category1, category2;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//        init();
//        addListener();
//
//        db = FirebaseDatabase.getInstance();
//        //db.setPersistenceEnabled(true);
//        rdb = db.getReference("post_list");
//        connectDB();
//
//    }
//
//
//
//
//    private void addListener() {
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(SearchActivity.this, PostActivity.class);
//                intent.putExtra("post", data.get(position));
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void init() {
//        search = getIntent().getStringExtra("searchtext");
//        edit = findViewById(R.id.searched_text);
//        edit.setText(search);
//
//        data = new ArrayList<>();
//        data.add(new Post("공지1 제목", "공지1 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척"));
//        data.add(new Post("공지2 제목", "공지2 내용입니다. 아웃백 먹고싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다", true));
//        data.add(new Post("공지3 제목", "공지3 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 크림떡볶이 먹고싶다"));
//        data.add(new Post("공지4 제목", "공지4 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 양념막창 먹고싶다"));
//        data.add(new Post("공지5 제목", "공지5 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 소곱창 먹고싶다"));
//        adapter = new ListAdapter(getApplicationContext(), R.layout.list_item, data);
//
//        list = findViewById(R.id.search_list);
//        list.setAdapter(adapter);
//    }
//
//    public void connectDB() {
//
//        rdb.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String s1 = snapshot.child("title").getValue().toString();
//                    String s2 = snapshot.child("content").getValue().toString();
//                    String s3 = snapshot.child("scrap").getValue().toString();
//                    boolean b = false;
//                    if (s3.equals("true")) {
//                        b = true;
//                    } else if (s3.equals("false")) {
//                        b = false;
//                    }
//                    Post p = new Post(s1, s2, b);
//                    //Log.i("DB확인", p.getTitle());
//                    data.add(p);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
//
//    public void search() {
//        search = getIntent().getStringExtra("searchtext");
//        rdb.child("title").addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//
//}

package com.example.hellonotice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Post> data;
    SearchActivityAdapter adapter;
    String search;
    EditText edit;
    FirebaseDatabase db;
    DatabaseReference rdb;

    ImageView btn1, btn2;
    ListView list1, list2;
    TextView t1, t2;
    Intent getfromadd;
    String category1, category2;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        addListener();

        db = FirebaseDatabase.getInstance();
        //db.setPersistenceEnabled(true);
        rdb = db.getReference("post_list");
        connectDB();

    }


    private void addListener() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchActivity.this, PostActivity.class);
                intent.putExtra("post", data.get(position));
                startActivity(intent);

                db = FirebaseDatabase.getInstance();
                db.setPersistenceEnabled(true);
                rdb = db.getReference("post_list");

            }
        });
    }

    private void init() {
        search = getIntent().getStringExtra("searchtext");
        edit = findViewById(R.id.searched_text);
        edit.setText(search);

        data = new ArrayList<>();
        data.add(new Post("공지1 제목", "공지1 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척 어쩌구 저쩌구 대충 웹 크롤링한 척"));
        data.add(new Post("공지2 제목", "공지2 내용입니다. 아웃백 먹고싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다 투움바 파스타 먹고 싶다", true));
        data.add(new Post("공지3 제목", "공지3 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 크림떡볶이 먹고싶다"));
        data.add(new Post("공지4 제목", "공지4 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 양념막창 먹고싶다"));
        data.add(new Post("공지5 제목", "공지5 내용입니다. 어쩌구 저쩌구 대충 웹 크롤링한 척 소곱창 먹고싶다"));

        btn1 = findViewById(R.id.searchBtn);
        btn2 = findViewById(R.id.scrapBtn);
        edit = findViewById(R.id.search_text);
        list1 = findViewById(R.id.list1_main);
        //list2 = findViewById(R.id.list2_main);
        t1 = findViewById(R.id.main_category1);
        //t2 = findViewById(R.id.main_category2);
        //t1.setText(category1);
        //t2.setText(category2);

        data = new ArrayList<>();
        data.clear();
        adapter = new SearchActivityAdapter(getApplicationContext(), R.layout.main_item, data);

//        list1.setAdapter(adapter);

        list = findViewById(R.id.search_list);
        list.setAdapter(adapter);
    }


    public void connectDB() {

        rdb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String s1 = snapshot.child("title").getValue().toString();
                    String s2 = snapshot.child("content").getValue().toString();
                    String s3 = snapshot.child("scrap").getValue().toString();
                    boolean b = false;
                    if (s3.equals("true")) {
                        b = true;
                    } else if (s3.equals("false")) {
                        b = false;
                    }
                    Post p = new Post(s1, s2, b);
                    //Log.i("DB확인", p.getTitle());
                    data.add(p);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}