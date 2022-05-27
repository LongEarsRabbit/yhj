package com.example.day009;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jetbrains.annotations.NotNull;

/**
 * @Date 2022/5/27
 */
public class UploadWorker extends Worker {
    String TAG = "a--";
    public UploadWorker(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Result doWork() {
        Log.i(TAG, "doWork: ");
        return Result.success();
    }
}
