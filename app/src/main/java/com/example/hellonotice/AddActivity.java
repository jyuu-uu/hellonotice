package com.example.hellonotice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private Spinner sp1, sp2, sp3;
    private ArrayList<String> arr1, arr2, arr3, arr4;
    private ArrayAdapter<String> adap1, adap2, adap3, adap4;
    private TextView addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
        addListener();
    }

    private void addListener() {
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    sp2.setEnabled(false);
                    sp3.setAdapter(adap3);
                } else if (position == 1) {
                    sp2.setEnabled(true);
                    sp3.setAdapter(adap4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                String s = "▶ "+sp1.getSelectedItem().toString()+" > "+sp2.getSelectedItem().toString()+" > "+sp3.getSelectedItem().toString();
                intent.putExtra("category", s);
                startActivity(intent);
            }
        });
    }

    protected void init() {
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        arr3 = new ArrayList<>();
        arr4 = new ArrayList<>();

        arr1.add("학교 홈페이지");
        arr1.add("학과 홈페이지");

        arr2.add("");
        arr2.add("소프트웨어학과");
        arr2.add("컴퓨터공학과");
        arr2.add("전기전자공학부");

        arr3.add("학사");
        arr3.add("장학");
        arr3.add("취창업/국제");
        arr3.add("학생/산학");

        arr4.add("공지사항");
        arr4.add("취업/특강공지");

        sp1 = findViewById(R.id.spinner1);
        sp2 = findViewById(R.id.spinner2);
        sp3 = findViewById(R.id.spinner3);

        adap1 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arr1);
        adap2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arr2);
        adap3 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arr3);
        adap4 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arr4);

        sp1.setAdapter(adap1);
        sp2.setAdapter(adap2);
        sp3.setAdapter(adap3);

        addBtn = findViewById(R.id.add_btn);
    }
}
