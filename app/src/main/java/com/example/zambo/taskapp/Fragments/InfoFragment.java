package com.example.zambo.taskapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zambo.taskapp.API.APIServices.TokenService;
import com.example.zambo.taskapp.API.APIServices.UserService;
import com.example.zambo.taskapp.API.APIToken;
import com.example.zambo.taskapp.API.APIUser;
import com.example.zambo.taskapp.API.APIUserLogin;
import com.example.zambo.taskapp.Models.Token;
import com.example.zambo.taskapp.Models.User;
import com.example.zambo.taskapp.Models.UserLogin;
import com.example.zambo.taskapp.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton fab;
    private EditText editTextEmail;
    private EditText editTextPassword;


    public InfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        fab = view.findViewById(R.id.fab);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        //String email = editTextEmail.getText().toString();
        //String password = editTextPassword.getText().toString();
        //String getHash = "false";

        TokenService service = APIToken.getApi().create(TokenService.class);
        JsonObject object = null;
        try {
            object = new JsonObject();
            object.addProperty("email","salva@salva.com");
            object.addProperty("password", "salva");
            object.addProperty("getHash", true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Call<Token> userCall = service.userLogin(object);
        userCall.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Token token = response.body();
                if(response.isSuccessful()){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Exito");
                builder.setMessage(token.getToken());
                builder.setNeutralButton("Got it", null);
                AlertDialog dialog = builder.create();
                dialog.show();}
                else{
                    Toast.makeText(getContext(),"Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                t.getMessage();
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}





