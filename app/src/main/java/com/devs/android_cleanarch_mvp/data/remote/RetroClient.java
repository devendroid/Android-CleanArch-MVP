package com.devs.android_cleanarch_mvp.data.remote;



import com.devs.android_cleanarch_mvp.MyApplication;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ${Deven} on 9/14/18.
 */
public class RetroClient {


   private static Retrofit retrofit;

    public static RestApi restApi() {

        synchronized (Retrofit.class) {
            Retrofit.Builder rb = new Retrofit.Builder();
            rb.baseUrl(RestApi.BASEPATH);
            rb.addConverterFactory(GsonConverterFactory.create());
            rb.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            if(MyApplication.ENABLE_API_DEBUGGER) {
                //rb.client(new OkHttpClient.Builder().addInterceptor(new LogJsonInterceptor()).build());
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                rb.client(new OkHttpClient.Builder().addInterceptor(interceptor).build());
            }
            retrofit = rb.build();

        }
        return  retrofit.create(RestApi.class);
    }

}
