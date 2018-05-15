package com.example.ai.toucheventdispatchandintercept;

import android.view.MotionEvent;

/**
 * Created by maoyu on 2018/5/15.
 *
 * @author chenwanfeng
 * @email 237142681@qq.com
 */

public class Utils {
    public static String getActionString(MotionEvent ev){
     String ac = "";
     switch (ev.getAction()){
         case MotionEvent.ACTION_DOWN:
             ac = "ACTION_DOWN";
             break;
         case MotionEvent.ACTION_UP:
             ac = "ACTION_UP";
             break;
         case MotionEvent.ACTION_MOVE:
             ac = "ACTION_MOVE";
             break;
         case MotionEvent.ACTION_CANCEL:
             ac = "ACTION_CANCEL";
             break;
     }
     return ac;
    }
}
