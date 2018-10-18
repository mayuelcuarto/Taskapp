package com.example.zambo.taskapp.API;

import com.example.zambo.taskapp.API.Deserializers.Deserializer;
import com.example.zambo.taskapp.API.Deserializers.TokenDeserializer;
import com.example.zambo.taskapp.Models.Token;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIToken {
    public static final String BASE_URL = "http://192.168.1.3/api_symfony4/public/";
    private static Retrofit retrofit = null;


    public static Retrofit getApi(){
        if(retrofit == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Token.class, new TokenDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
