package com.example.hellonotice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView btn1;
    ListView list1, list2;
    MainAdapter adapter, adapter2;
    ArrayList<Post> data, data2;
    TextView t1, t2;
    Intent getfromadd;
    EditText edit;
    String category1, category2;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rdb;
    FloatingActionButton fab, fab1, fab2;
    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (db == null) {
            db.setPersistenceEnabled(true);
        } else {
            db = FirebaseDatabase.getInstance();
            //db.setPersistenceEnabled(true);
            rdb = db.getReference("post_list");
        }

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        listener listener = new listener();
        fab.setOnClickListener(listener);
        fab1.setOnClickListener(listener);
        fab2.setOnClickListener(listener);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
        getfromadd = getIntent();
        if (getfromadd != null) {
            category2 = getfromadd.getStringExtra("category");
        }
        category1 = "▶ 학교 홈페이지 > 학사";
        init();
        connectDB();
        addListener();
    }

    public class listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            Intent intent;
            switch (id) {
                case R.id.fab:
                    anim();
                    break;
                case R.id.fab1:
                    anim();
                    intent = new Intent(MainActivity.this, AddActivity.class);
                    startActivity(intent);
                    break;
                case R.id.fab2:
                    anim();
                    intent = new Intent(MainActivity.this, ScrapActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

        public void anim() {

            if (isFabOpen) {
                fab1.startAnimation(fab_close);
                fab2.startAnimation(fab_close);
                fab1.setClickable(false);
                fab2.setClickable(false);
                isFabOpen = false;
            } else {
                fab1.startAnimation(fab_open);
                fab2.startAnimation(fab_open);
                fab1.setClickable(true);
                fab2.setClickable(true);
                isFabOpen = true;
            }
        }


        @Override
        protected void onResume() {
            super.onResume();
        }

        private void addListener() {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    intent.putExtra("searchtext", edit.getText().toString());
                    //Toast.makeText(getApplicationContext(), edit.getText(), Toast.LENGTH_SHORT).show();
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
            edit = findViewById(R.id.search_text);
            list1 = findViewById(R.id.list1_main);
            list2 = findViewById(R.id.list2_main);
            t1 = findViewById(R.id.main_category1);
            t2 = findViewById(R.id.main_category2);
            t1.setText(category1);
            t2.setText(category2);

            data = new ArrayList<>();
            data.clear();
            adapter = new MainAdapter(getApplicationContext(), R.layout.main_item, data);
            //data.add(new Post("존나 제목", "존나 내용", false));

            list1.setAdapter(adapter);

            if (category2 != null) {
                data2 = new ArrayList<>();
                data2.clear();
                adapter2 = new MainAdapter(getApplicationContext(), R.layout.main_item, data2);

                rdb = db.getReference("post_list3");
                rdb.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String s1 = snapshot.child("title").getValue().toString();
                            String s2 = snapshot.child("content").getValue().toString();
                            String s3 = snapshot.child("scrap").getValue().toString();
                            String s4 = snapshot.child("id").getValue().toString();

                            boolean b = false;
                            if (s3.equals("true")) {
                                b = true;
                            } else if (s3.equals("false")) {
                                b = false;
                            }
                            Post p = new Post(s4, s1, s2, b);
                            Log.i("DB확인", p.getTitle());
                            data2.add(p);
                        }
                        adapter2.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

                list2.setAdapter(adapter2);
                list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, PostActivity.class);
                        intent.putExtra("post", data2.get(position));
                        startActivity(intent);
                    }
                });
            }
        }

        public void connectDB() {

            rdb = db.getReference("post_list");
            rdb.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String s1 = snapshot.child("title").getValue().toString();
                        String s2 = snapshot.child("content").getValue().toString();
                        String s3 = snapshot.child("scrap").getValue().toString();
                        String s4 = snapshot.child("id").getValue().toString();

                        boolean b = false;
                        if (s3.equals("true")) {
                            b = true;
                        } else if (s3.equals("false")) {
                            b = false;
                        }
                        Post p = new Post(s4, s1, s2, b);
                        Log.i("DB확인", p.getTitle());
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
