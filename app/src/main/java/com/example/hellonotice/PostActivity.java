package com.example.hellonotice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class PostActivity extends AppCompatActivity implements Button.OnClickListener{
    private DatabaseReference mPostReference;
    FirebaseDatabase db;
    DatabaseReference rdb;

    Post p;
    TextView t1, t2;
    ImageButton btn;

    //ArrayAdapter<String> arrayAdapter;
    //MainAdapter adapter;
    //ArrayList<Post> data;

    //static ArrayList<String> arrayIndex = new ArrayList<String>();
    //static ArrayList<String> arrayData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Intent intent = getIntent();
        p = (Post)intent.getSerializableExtra("post");
        init();

        db = FirebaseDatabase.getInstance();
        rdb = db.getReference("post_list");



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

                //Log.i("datanoti", "값 바꼇능가,,");
            }
        });
        //connectDB();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.post_scrap:
                Log.i("scrap","btn 클릭");
                if(p.isScrap()){
                    p.setScrap(false);
                    btn.setImageResource(R.drawable.scrap_btn);
                }
                else{
                    p.setScrap(true);
                    btn.setImageResource(R.drawable.scrap_btn_pink);
                }
                //postFirebaseDatabas(true);
        }
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
        //arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        //getFirebaseDatabase();
    }


/*
    public void getFirebaseDatabase() {
        ValueEventListener postLisetener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("getFirebaseDatabase", "key: " + dataSnapshot.getChildrenCount());
                arrayData.clear();
                arrayIndex.clear();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String key = postSnapshot.getKey();
                    Post get = postSnapshot.getValue(Post.class);
                    String[] info = {get.title, get.content, String.valueOf(get.scrap)};
                    String Result = setTextLength(info[0], 10) + setTextLength(info[1], 10)
                            + setTextLength(info[2],10);
                    arrayData.add(Result);
                    arrayIndex.add(key);
                    Log.d("getFirebaseDatabase", "key: "+key);
                    Log.d("getFirebaseDatabase", "info: "+info[0]+info[1]+info[2]);
                }
                arrayAdapter.clear();
                arrayAdapter.addAll(arrayData);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("getFirebaseDatabase","loadPost:onCancelled", databaseError.toException());
            }
        };
        Query sortbynum = FirebaseDatabase.getInstance().getReference().child("post_list").orderByChild(sort);
        sortbynum.addListenerForSingleValueEvent(postLisetener);
    }

    public String setTextLength (String text, int length) {
        if(text.length() < length) {
            int gap = length - text.length();
            for(int i=0; i<gap; i++) {
                text= text+ " ";
            }
        }
        return text;
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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<> ();
        result.put("scrap",!p.isScrap());
        return result;
    }

    //true만 쓰면 됨
    public void postFirebaseDatabas(boolean add) {
        mPostReference = FirebaseDatabase.getInstance().getReference();
        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add) {
            PostActivity post = new PostActivity();
            postValues = post.toMap();
        }
        childUpdates.put("/id_list/"+p.title, postValues);
        mPostReference.updateChildren(childUpdates);
    }
*/
}