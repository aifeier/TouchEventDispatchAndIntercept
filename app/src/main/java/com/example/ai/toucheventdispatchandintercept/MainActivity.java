package com.example.ai.toucheventdispatchandintercept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/* 参考文章： https://www.jianshu.com/p/6d6f83b31faa  */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*分发*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent.Action: " + Utils.getActionString(ev));
        /*在本层不再继续分发*/
        /*当前为Activity，则交给上层（系统）处理*/
//        return false;
        /*在本层，本Activity中消费所有事件，不交给上层，也不传给下层*/
//        return true;
        /*默认传递到activity的第一个view中处理*/
        /*事件将分发给本层的事件拦截onInterceptTouchEvent 方法进行处理,由于Activity没有该方法，则传递到子View的dispatch方法*/
        /*这里就是CustomLinearLayout*/
        return super.dispatchTouchEvent(ev);
    }

    /*消费*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent.Action: " + Utils.getActionString(event));
              /*消费事件，不再传递*/
//        return true;
        /*不消费/响应事件，该事件不断向上层View的nTouchEvent方法，
        直到某个View的onTouchEvent方法返回True，
        如果到最顶层还没有false，则系统判断同一个事件系列，当前View无法再次接收到事件*/
//        return  false;
        /*不响应事件，结果和false一样*/
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        String msg = null;
        switch (v.getId()) {
            case R.id.linearLayout:
                /*viewGroup*/
                Log.e(TAG, "onClick.View: linearLayout");
                msg = "you click linearLayout";
                break;
            case R.id.text:
                Log.e(TAG, "onClick.View: text");
                msg = "you click textView";
                break;
        }

        if (null != msg) {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }
}
