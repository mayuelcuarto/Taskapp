package com.example.zambo.taskapp.API.Deserializers;

import com.example.zambo.taskapp.Models.User;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Cristhian on 20-12-2017.
 */

public class UserLoginDeserializer implements JsonDeserializer<User> {

    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int id = json.getAsJsonObject().get("sub").getAsInt();
        String email = json.getAsJsonObject().get("email").getAsString();
        String name = json.getAsJsonObject().get("name").getAsString();
        String surname = json.getAsJsonObject().get("user").getAsJsonObject().get("surname").getAsString();
        int iat = json.getAsJsonObject().get("iat").getAsInt();
        int exp = json.getAsJsonObject().get("exp").getAsInt();
        User user = new User(id, email, name, surname, iat, exp);
        return user;
    }
}
