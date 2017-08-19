package com.sunil.mvp.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by sunil on 12-08-2017.
 */

public class MyOkHttpInterceptor implements Interceptor {
    private final String TAG = MyOkHttpInterceptor.class.getSimpleName();
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String body = "NA";
        if(chain.request().body()!=null){
            body =  bodyToString(chain.request().body());
        }

        String myString = request.url() + " ->" + request.headers().toString()+"\n Params  --->"+body+"\n";

        Log.d(TAG, myString);
        return chain.proceed(request);
    }

    private  String bodyToString(final RequestBody request){
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            copy.writeTo(buffer);
            return buffer.readUtf8();
        }
        catch (final IOException e) {
            return "did not work";
        }
    }

}