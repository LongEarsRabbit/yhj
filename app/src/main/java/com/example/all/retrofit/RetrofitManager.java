package com.example.all.retrofit;

import com.google.gson.Gson;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Date 2022/5/23
 */
public class RetrofitManager {
    private static RetrofitManager manger;
    private RetrofitManager(){}
    public static RetrofitManager getInstance(){
        if(manger == null){
            manger = new RetrofitManager();
        }
        return manger;
    }
    private Retrofit retrofit;
    public Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://www.qubaobei.com/")
                    .client(new OkHttpClient.Builder()
                            .addInterceptor(chain -> chain.proceed(chain.request().newBuilder().build()))
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .writeTimeout(2, TimeUnit.MINUTES)
                            .readTimeout(2, TimeUnit.MINUTES)
                            .connectTimeout(2, TimeUnit.MINUTES)
                            .build())
                    .build();
        }
        return retrofit;
    }
}
