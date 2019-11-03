package com.example.hellonotice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView btn1, btn2;
    ListView list1, list2;
    MainAdapter adapter;
    ArrayList<Post> data;
    TextView t1, t2;
    Intent getfromadd;
    EditText edit;
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
        category1 = "▶ 학교 홈페이지 > 학사";
        init();
        addListener();
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
        edit = findViewById(R.id.search_text);
        list1 = findViewById(R.id.list1_main);
        list2 = findViewById(R.id.list2_main);
        t1 = findViewById(R.id.main_category1);
        t2 = findViewById(R.id.main_category2);
        t1.setText(category1);
        t2.setText(category2);

        data = new ArrayList<>();
        data.add(new Post("휴학생 계절학기 수강 안내", "휴학생의 계절학기 수강자격 및 신청학점과 관련하여 신설 내용을 안내합니다.\n" +
                "\n" +
                "■ 수강 자격\n" +
                "\n" +
                "변경 전\n" +
                "\n" +
                "변경 후\n" +
                "\n" +
                "비고\n" +
                "\n" +
                "해당 방학 직전 정규학기 등록을 필한 본교 서울 및 GLOCAL 캠퍼스 학부 재학생\n" +
                "\n" +
                "좌동\n" +
                "\n" +
                "변경 없음\n" +
                "\n" +
                "<신 설>\n" +
                "\n" +
                "수업연한을 초과하지 않은 본교 서울 및 GLOCAL 캠퍼스 학부 휴학생\n" +
                "\n" +
                "‘미졸구분’이 부여되지 않은 휴학생\n" +
                "\n" +
                "※ 수의예과 및 수의학과 휴학생은 수의과대학장이 인정한 학생만 가능"));
        data.add(new Post("2020학년도 전기 대학원(일반·전문·특수) 석·박사 신입생 모집안내", "대학원명\n" +
                "\n" +
                "일반대학원\n" +
                "\n" +
                "홈페이지\n" +
                "\n" +
                "서울 http://grad.konkuk.ac.kr / 글로컬 http://grad.kku.ac.kr\n" +
                "\n" +
                "모집학과\n" +
                "\n" +
                "서울\n" +
                "\n" +
                "- 석사과정: 5계열 72개 학과, 7개 학과간 협동과정\n" +
                "\n" +
                "- 박사과정: 5계열 69개 학과, 6개 학과간 협동과정\n" +
                "\n" +
                "- 통합과정: 5계열 32개 학과, 3개 학과간 통합과정\n" +
                "\n" +
                "글로컬\n" +
                "\n" +
                "- 석사과정: 23개 학과, 36개 전공\n" +
                "\n" +
                "- 박사과정: 21개 학과, 34개 전공\n" +
                "\n" +
                "특이사항\n" +
                "\n" +
                "신설학과: 컴퓨터공학과(컴퓨터․정보통신공학과와 소프트웨어학과 통합)\n" +
                "\n" +
                "스마트ICT융합공학과\n" +
                "\n" +
                "계열변경: 지리학과가 자연과학계열에서 인문사회계열로 변경\n" +
                "\n" +
                "원서접수 일자\n" +
                "\n" +
                "서울 10. 11.(금) ~ 10. 21.(월) 17:00 / 글로컬 10. 21.(월) ~ 11. 1.(금)\n" +
                "\n" +
                "문의처\n" +
                "\n" +
                "서울 (02) 450 – 3263, 3261 / 글로컬 (043) 840 - 3235", true));
        data.add(new Post("2019학년도 2학기 취득학점포기 안내", "2019학년도 2학기 취득학점포기 신청 일정을 아래와 같이 안내하오니 기간 내에 신청하여 주시기 바랍니다.\n" +
                "\n" +
                "1. 신청기간 및 신청대상\n" +
                "구분\n" +
                "\n" +
                "신청기간\n" +
                "\n" +
                "신청대상\n" +
                "\n" +
                "포기성적\n" +
                "\n" +
                "비고\n" +
                "\n" +
                "1차\n" +
                "\n" +
                "2019. 9. 19.(목) 09:30~9. 20.(금) 17:00(2일)\n" +
                "\n" +
                "8학기 이상\n" +
                "재학생\n" +
                "\n" +
                "~2019.1학기까지의 성적\n" +
                "\n" +
                "휴학생\n" +
                "\n" +
                "신청 불가\n" +
                "\n" +
                "2차\n" +
                "\n" +
                "2020. 1. 6.(월) 09:30~1. 7.(화) 17:00(2일)\n" +
                "\n" +
                "5학기 이상\n" +
                "재학생\n" +
                "\n" +
                "3차\n" +
                "\n" +
                "2020. 1. 13.(월) 09:30~1. 14.(화) 17:00(2일)\n" +
                "\n" +
                "2020.2월\n" +
                "졸업예정자\n" +
                "\n" +
                "2019.2학기 성적"));
        data.add(new Post("[교내] 2019년 2학기 건국글로벌리더인증 장학금 신청 안내(11/06-11/28)", " 2019년 2학기 건국글로벌리더인증 장학금 신청안내\n" +
                "\n" +
                "\n" +
                "              2019학년도 2학기 건국글로벌리더인증 장학금 신청을 아래와 같이 안내하오니 많은 신청바랍니다\n" +
                "\n" +
                "1. 신청기간 : 2019. 11. 06.(수) ~ 11. 28.(목) 09:00 ~ 17:00 까지\n" +
                "                    (점심시간: 12:00 ~ 13: 00 제외)\n" +
                "2. 제출장소 : 학생회관 2층 장학복지팀\n" +
                "3. 신청방법 : 장학복지팀 방문접수(장학신청 서류 일체)\n" +
                "4. 지급대상 : 정규학기 학부 재학생\n" +
                "5. 장학금액 : 1,000,000원(등록금 범위내 지급)\n" +
                "6. 선발요건 : 첨부파일 <2019.2학기 건국 글로벌리더 인증제 안내> 필히 참조 요망\n" +
                "7. 제출서류\n" +
                "      (1) 건국글로벌리더인증 장학 신청서 1부\n" +
                "      (2) 어학성적표 원본 1부\n" +
                "      (3) 정보화자격증 원본 1부"));
        data.add(new Post("2019학년도 동계 계절학기 개설 계획", "1. 목적: 조기졸업, 다(부)전공 등 다양한 이유로 학업 보완을 희망하는 학생들에게 학점취득의 기회 부여\n" +
                "\n" +
                "2. 근거: 학칙 제5조 제2항, 제6조 제2항, 제8조 제2항, 제13조, 제26조 제2항, 제57조의2 제6항,  \n" +
                "             학칙시행세칙 제16조, 제17조, 강사료지급규정\n" +
                "3. 주요일정"));
        adapter = new MainAdapter(getApplicationContext(), R.layout.main_item, data);
        list1.setAdapter(adapter);
        if (category2 != null) {
            list2.setAdapter(adapter);
        }
    }
}
