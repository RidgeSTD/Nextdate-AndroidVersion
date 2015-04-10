package com.daggerstudio.lunar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.daggerstudio.lunar.util.Lunar;
import com.daggerstudio.lunar.util.LunarExecutor;
import com.daggerstudio.lunar.util.Solar;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    DatePicker mDatePicker = null;
    TextView mTextView1 = null;
    TextView mTextView2 = null;
    Button mButton = null;
    Lunar mLunar = null;
    Solar mSolar = null;
    String strBuf = "";
    Calendar mCalendar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatePicker = (DatePicker)findViewById(R.id.datePicker);
        mButton = (Button)findViewById(R.id.button);
        mTextView1 = (TextView)findViewById(R.id.textView1);
        mTextView2 = (TextView)findViewById(R.id.textView2);

        mButton.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(mSolar == null){
                mSolar = new Solar();
            }
            if(mLunar == null){
                mLunar = new Lunar();
            }
            if(mCalendar == null){
                mCalendar = Calendar.getInstance();
            }
            mCalendar.set(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth());
            mCalendar.add(Calendar.HOUR, 24);

            mSolar.solarDay = mCalendar.get(Calendar.DAY_OF_MONTH);
            mSolar.solarMonth = mCalendar.get(Calendar.MONTH)+1;
            mSolar.solarYear = mCalendar.get(Calendar.YEAR);
            mLunar = LunarExecutor.SolarToLunar(mSolar);
            strBuf = "第二天的公历表示为"+mCalendar.get(Calendar.YEAR)+"年"+(mCalendar.get(Calendar.MONTH)+1)+"月"+mCalendar.get(Calendar.DAY_OF_MONTH)+"日";
            mTextView1.setText(strBuf);
            strBuf = "第二天的农历表示为"+LunarExecutor.lunarYearToGanZhi(mLunar.lunarYear)+mLunar.lunarMonth+"月"+mLunar.lunarDay+"日";
            mTextView2.setText(strBuf);
            Toast.makeText(v.getContext(), "计算完成", Toast.LENGTH_SHORT).show();
        }
    }
}
