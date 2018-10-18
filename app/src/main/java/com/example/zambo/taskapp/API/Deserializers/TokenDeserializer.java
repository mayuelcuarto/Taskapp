package com.example.zambo.taskapp.API.Deserializers;

import com.example.zambo.taskapp.Models.Token;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class TokenDeserializer implements JsonDeserializer<Token> {

    @Override
    public Token deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String tokenRes = json.getAsString();
        Token token = new Token(tokenRes);
        return token;
    }
}
