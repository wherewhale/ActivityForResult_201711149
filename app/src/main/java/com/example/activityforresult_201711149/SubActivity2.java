package com.example.activityforresult_201711149;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity2 extends AppCompatActivity {
    EditText edit; //edit 은 EditText 형태의 데이터임을 알림
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2); //본 Activity 의 레이아웃은 activity_sub2 임을 알림
        edit = (EditText) findViewById(R.id.edit); //edit 은 activity_sub2 의 edit 임을 확인
        Button button_ok = (Button) findViewById(R.id.button_ok); //본 activity 의 button_ok 는 activity_sub2 의 button_ok 와 같음을 선언
        button_ok.setOnClickListener(new View.OnClickListener() { //button_ok 에 클릭 리스너 부착
            public void onClick(View v) { //클릭 이벤트 생성
                Intent intent = new Intent(); //인텐트 생성
                intent.putExtra("INPUT2_TEXT", edit.getText().toString()); //인텐트에 INPUT2_TEXT 라는 이름의 edit 의 글자 데이터 삽입
                setResult(RESULT_OK, intent); //결과로 RESULT_OK 코드와 intent 첨부
                finish(); //이벤트 종료
            }
        });
        Button button_cancel = (Button) findViewById(R.id.button_cancel); //본 activity 의 button_cancel 은 activity_sub2 의 button_cancel 임을 선언
        button_cancel.setOnClickListener(new View.OnClickListener() { //button_cancel 에 클릭 리스너 부착
            public void onClick(View v) { //클릭 이벤트 생성
                setResult(RESULT_CANCELED); //결과 코드로 cancel 임을 첨부
                finish(); //이벤트 종료
            }
        });
    }
}