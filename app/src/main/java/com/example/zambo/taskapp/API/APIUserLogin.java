package com.example.zambo.taskapp.API;

import com.example.zambo.taskapp.API.Deserializers.UserLoginDeserializer;
import com.example.zambo.taskapp.Models.User;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Cristhian on 20-12-2017.
 */

public class APIUserLogin {

    public static final String BASE_URL = "http://192.168.1.3/api_symfony4/public/";
    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if(retrofit == null) {

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(User.class, new UserLoginDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }

}
