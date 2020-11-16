package com.example.activityforresult_201711149;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    EditText edit; //EditText 형태의 edit 선언
    TextView text; //TextView 형태의 text 선언
    static final int GET_STRING2 = 1; //결과 코드 공유를 위한 전역변수 선언

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub); //레이아웃이 activity_sub 임을 알림
        edit = (EditText) findViewById(R.id.edit); //edit 은 activity_sub 에 존재하는 edit 으로 할당
        text = (TextView) findViewById(R.id.textView2); //text 는 activity_sub 에 존재하는 textView2 로 할당
        Button button_ok = (Button) findViewById(R.id.button_ok); //button_ok 은 activity_sub 의 button_ok 임을 알림
        Button button = (Button) findViewById((R.id.second_button)); //button 은 activity_sub 의 second_button 임을 알림
        button_ok.setOnClickListener(new View.OnClickListener() { //button_ok 에 onClickListener 부착
            public void onClick(View v) { //클릭 이벤트 생성
                Intent intent = new Intent(); //인텐트 생성
                intent.putExtra("INPUT1_TEXT", edit.getText().toString()); //인텐트에 INPUT1_TEXT 라는 이름을 가진 edit 의 글자 데이터 첨부
                intent.putExtra("INPUT2_TEXT", text.getText().toString()); //인텐트에 INPUT2_TEXT 라는 이름을 가진 text 의 글자 데이터 첨부
                setResult(RESULT_OK, intent); //결과 코드 1과 intent 를 첨부하여 결과 공유
                finish(); //이벤트 종료
            }
        });
        button.setOnClickListener(new View.OnClickListener() { //button 에 onClickListener 부착
            public void onClick(View arg0) { //클릭 이벤트 생성
                Intent in = new Intent(SubActivity.this, SubActivity2.class); //intent 생성 및 목적지 선언 (SubActivity2)
                startActivityForResult(in, GET_STRING2); //인텐트와 결과코드 공유
            }
        });
        Button button_cancel = (Button) findViewById(R.id.button_cancel);  //button_cancel 이 activity_sub 의 button_cancel 임을 알림
        button_cancel.setOnClickListener(new View.OnClickListener() { //button_cancel 에도 클릭 리스너 부착
            public void onClick(View v) { //클릭 이벤트 생성
                setResult(RESULT_CANCELED); //결과 코드가 Canceled 된 것임을 알림
                finish(); //이벤트 종류
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //sub2 로 부터 받은 결과를 확인
        if (requestCode == GET_STRING2) { //요청 코드가 GET_STRING2와 같은 경우, (sub2 로부터 시작된 활동이라면)
            if (resultCode == RESULT_OK) { //그리고 결과 코드가 RESULT_OK 라면
                text.setText(data.getStringExtra("INPUT2_TEXT")); //text 의 글자에 INPUT2_TEXT 라는 이름의 데이터를 삽입한다.
            }
        }
    }
}