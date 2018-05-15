package com.example.ai.toucheventdispatchandintercept;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by maoyu on 2018/5/15.
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class CustomTextView extends AppCompatTextView {

    private final String TAG = getClass().getSimpleName();

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*分发*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent.Action: " + Utils.getActionString(ev));
        /*不接收事件，本层不消费，不做处理*/
        /*传递给上一次的OnTouchEvent处理*/
//        return false;
        /*在本层消费掉，但不会调用onTouchEvent，需要使用super或者直接调用onTouchEvent方法*/
//        return true;
        /*在本层消费掉，super中调用了onTouchEvent方法*/
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
        /*如果存在点击事件,还是能响应,内部做了处理*/
        return super.onTouchEvent(event);
    }
}
