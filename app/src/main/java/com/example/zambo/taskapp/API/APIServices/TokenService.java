package com.example.zambo.taskapp.API.APIServices;

import com.example.zambo.taskapp.Models.Token;
import com.example.zambo.taskapp.Models.UserLogin;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Cristhian on 20-12-2017.
 */

public interface TokenService {
    @POST("login")
    @FormUrlEncoded
    Call<Token> userLogin(@Field("json") JsonObject json);
}
