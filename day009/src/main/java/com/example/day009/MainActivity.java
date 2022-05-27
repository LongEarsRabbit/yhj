package com.example.day009;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义约束
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresCharging(true)
                .build();
        //1对象是Work
        //UploadWorker

        //2怎么做 WorkRequest
        OneTimeWorkRequest build = new OneTimeWorkRequest.Builder(UploadWorker.class)
                //添加约束
//                .setConstraints(constraints)
                //加急
//                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .build();
        // 定时  不能小于15分钟
//        PeriodicWorkRequest saveRequest =
//                new PeriodicWorkRequest.Builder(UploadWorker.class, 1, TimeUnit.HOURS)
//                        // Constraints
//                        .build();
        //3调度 WorkManager
        WorkManager.getInstance(this).enqueue(build);
        //4约束



    }









}