package com.example.tech_2.accessibilityexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(getApplicationContext())) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));

                ServiceConnection mPodServiceConn = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName className, IBinder service) {
                        Log.e("service", "Pod: Service Connected");
//                        Object mPodService = IPodService.Stub.asInterface(service); //here i am getting NullPointerException
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {
                        System.out.println("service disconnected");
                    }
                };
//                bindService(intent,mPodServiceConn, Contex);
                startActivityForResult(intent, 1);
            }
        }

        // Code to start the Service
        startService(new Intent(getApplication(), MyService.class));
    }
}
