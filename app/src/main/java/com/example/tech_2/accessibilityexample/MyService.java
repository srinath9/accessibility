package com.example.tech_2.accessibilityexample;

/**
 * Created by tech-2 on 12/11/16.
 */


import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageView;


public class MyService extends AccessibilityService {
    WindowManager windowManager;
//    ImageView back,notification,minimize;
    EditText home;
    WindowManager.LayoutParams params;
    AccessibilityService service;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("RtlHardcoded")
    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

//        back = new ImageView(this);
//        home = new ImageView(this);
        home = new EditText(this);
//        minimize = new ImageView(this);

//        notification = new ImageView(this);

//        back.setImageResource(R.mipmap.ic_back);
//        back.setMaxWidth(10);
//        home.setImageResource(R.mipmap.ic_home);
        home.setMinWidth(500);
//        minimize.setImageResource(R.mipmap.ic_min);
//        minimize.setMaxWidth(10);
//        notification.setImageResource(R.mipmap.ic_notification);
//        notification.setMaxWidth(10);
        params= new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.CENTER_VERTICAL|Gravity.RIGHT;
        params.x = 10;
        params.y = 100;
        params.verticalMargin = 0;
        windowManager.addView(home, params);

        Bundle arguments = new Bundle();
        arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
                AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD);
        arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
                true);
//        home.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY,
//                arguments);
        ClipData clip = ClipData.newPlainText("label", "NEWDATA");
        ClipboardManager clipboard;
        clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);
//        usernode.performAction(AccessibilityNodeInfo.ACTION_PASTE);

        home.setContentDescription("hi");
        home.setFocusable(true);
//        android:hint="Invoice Amount"
        home.setHint("Inmount");
        home.setTextColor(Color.RED);
        home.setBackgroundColor(Color.GREEN);
        System.out.println(home.getAccessibilityClassName());

//        home.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
//        home.view



//        Accessibility.TYPE_VIEW_LONG_CLICKED;
        home.setAccessibilityDelegate(new View.AccessibilityDelegate(){

            @Override
            public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
                super.onPopulateAccessibilityEvent(host, event);
                System.out.println("populate *********2222 " );
                if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
//                    event.setContentDescription(/** your text */);
                    System.out.println("populate *********" );
                }
            }

//            @Override
//            public void AccessibilityEvent(){
//
//            }

            @Override
            public void onInitializeAccessibilityNodeInfo(View host,
                                                          AccessibilityNodeInfo info) {
                // Let the default implementation populate the info.
                System.out.println("asasda  asdas**********************" );
                super.onInitializeAccessibilityNodeInfo(host, info);
                System.out.println("asasda  asdas**********************" );
                // Set some other information.
                info.setEnabled(host.isEnabled());
            }

        });

//        AccessibilityNodeInfo source = event.getSource();
//        if (source != null & event.getClassName().equals("android.widget.EditText")) {
//            Bundle arguments = new Bundle();
//            arguments.putCharSequence(AccessibilityNodeInfo
//                    .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "android");
//            source.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
//        }

//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("--------********************----------");
//            }
//        });

//        public AccessibilityAction(int id, CharSequence label)
//        new AccessibilityAction(R.id.dismiss, getString(R.string.dismiss));
//        new AccessibilityAction(ACTION_CLICK,  getString(R.string.play_song));
//// Constants for all the standard actions with default label:
//        AccessibilityAction.ACTION_CLICK

        params= new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.CENTER_VERTICAL|Gravity.RIGHT;
        params.x = 10;
        params.y = 100;
        params.verticalMargin = 30;
        params.horizontalMargin = 60;
//        windowManager.addView(minimize, params);

        params= new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.CENTER_VERTICAL|Gravity.RIGHT;
        params.x = 10;
        params.y = 150;
        params.verticalMargin = 100;



//        windowManager.addView(notification, params);
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    performGlobalAction(Integer.parseInt(AccessibilityService.INPUT_METHOD_SERVICE));

                    System.out.println("home clcick ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        AccessibilityManager accessibilityManager = (AccessibilityManager) getApplicationContext().getSystemService(Context.ACCESSIBILITY_SERVICE);

        if (accessibilityManager.isEnabled()) {
//            accessibilityManager.
            home.setFocusable(true);
            home.setFocusableInTouchMode(true);
            home.requestFocus();
            System.out.println("acecessable ");
        }
        home.setFocusable(true);
        home.setFocusableInTouchMode(true);
        home.requestFocus();
        System.out.println("acecessable out ***********");
//        home.access


//        notification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        minimize.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
//        int xaas = event.TYPE_VIEW_LONG_CLICKED;
        System.out.println("event2  ");
    }

    @Override
    public void onInterrupt() {

        System.out.println("event  2d ");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d("TAG", "onServiceConnected**************/////////////////");
    }

}
