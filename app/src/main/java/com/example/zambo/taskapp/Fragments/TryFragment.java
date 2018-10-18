package com.example.zambo.taskapp.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zambo.taskapp.API.APIServices.UserService;
import com.example.zambo.taskapp.API.APIUser;
import com.example.zambo.taskapp.Models.User;
import com.example.zambo.taskapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TryFragment extends Fragment implements View.OnClickListener{

    private FloatingActionButton fab;

    public TryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_try, container, false);


        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        //Prueba de llamada de datos de usuario
        UserService service = APIUser.getApi().create(UserService.class);
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjM0LCJlbWFpbCI6InNhbHZhQHNhbHZhLmNvbSIsIm5hbWUiOiJTYWx2YWRvciIsInN1cm5hbWUiOiJMb3BleiIsImlhdCI6MTUzNzQxODMzMiwiZXhwIjoxNTM4MDIzMTMyfQ.68DJCmTdJT6bMUYVBdMxSDex-JfDTOIAJhBFeipCOiY";
        int id = 4;
        Call<User> loginCall = service.pruebas(token, id);

        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User usuario = response.body();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Token");
                builder.setMessage(usuario.getEmail());
                builder.setNeutralButton("Got it", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.print(t.getCause());
                Toast.makeText(getContext(),"Error al obtener token", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
