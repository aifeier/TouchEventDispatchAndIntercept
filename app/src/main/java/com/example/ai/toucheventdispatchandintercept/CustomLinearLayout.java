package com.example.ai.toucheventdispatchandintercept;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by maoyu on 2018/5/15.
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class CustomLinearLayout extends LinearLayout {
    private final String TAG = getClass().getSimpleName();

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*分发*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent.Action: " + Utils.getActionString(ev));
        /*不再本层及内部消费，调用上一层的onTouchEvent方法*/
        /*这里就是Activity的OnTouchEvent*/
//        return false;
        /*在本层消费，不会调用拦截和消费的方法，事件被消费，不再传递*/
//        return true;
        /*在本层消费，并根据拦截方法来进行向下传递或者调用本层的onTouchEvent方法消费*/
        return super.dispatchTouchEvent(ev);
    }

    /*拦截*/
    /*该方法只有View和ViewGroup有，Activity没有*/
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent.Action: " + Utils.getActionString(ev));
        /*不对事件拦截，并传递到子View的事件分发，没有子View则调用当前View的onTouchEvent方法*/
//        return false;
        /*对事件拦截，并交给本View的onTouchEvent方法*/
//        return true;
        /*对事件拦截，和return true一样，并交给本View的onTouchEvent方法*/
        return super.onInterceptTouchEvent(ev);
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
        return false;
        /*不响应事件，结果和false一样*/
        /*如果存在点击事件,还是能响应,内部做了处理*/
//        return super.onTouchEvent(event);
    }
}
