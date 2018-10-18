package com.example.zambo.taskapp.API;

import com.example.zambo.taskapp.API.Deserializers.Deserializer;
import com.example.zambo.taskapp.Models.User;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Cristhian on 20-12-2017.
 */

public class APIUser {

    public static final String BASE_URL = "http://192.168.1.3/api_symfony4/public/";
    //public static final String APPKEY = "de0991ce98d39641e9970324601d4d87";
    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if(retrofit == null) {

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(User.class, new Deserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }

}
