package com.example.activityforresult_201711149;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1; //전역변수 결과 코드 선언
    TextView text; //text 는 TextView 형임을 선언
    TextView text2; //text2 는 TextView 형임을 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button); //button 은 activity_main 의 button 임을 확인
        text = (TextView) findViewById(R.id.text); //text 는 activity_main 의 text 임을 확인
        text2 = (TextView) findViewById(R.id.text2); //text2 는 activity_main 의 text2 임을 확인
        button.setOnClickListener(new View.OnClickListener() { //button  에 onClickListener 부착
            public void onClick(View arg0) { //onClick 이벤트 생성
                Intent in = new Intent(MainActivity.this, SubActivity.class); //intent 할당 및 목적지 Activity 선언(SubActivity)
                startActivityForResult(in, GET_STRING); //Activity 실행 및 intent 와 결과코드 부착
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //Activity 실행 및 꺼진것의 결과로 값을 받아옴 (intent Data를 통해)
        if (requestCode == GET_STRING) { //resultCode 가 1 즉, MainActivity 로부터 시작된 활동이라면,
            if (resultCode == RESULT_OK) { // 그리고, Result 코드가 OK 로 왔다면
                text.setText(data.getStringExtra("INPUT1_TEXT")); //text 의 글자를 intent 로부터 받아온 INPUT1_TEXT 로 지정
                text2.setText(data.getStringExtra("INPUT2_TEXT")); //text2 의 글자를 intent 로부터 받아온 INPUT2_TEXT 로 지정
            }
        }
    }
}
