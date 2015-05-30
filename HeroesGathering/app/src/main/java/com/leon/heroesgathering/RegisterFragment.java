package com.leon.heroesgathering;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_register, container, false);
        final EditText usernameEditText=(EditText)v.findViewById(R.id.usernameEditText);
        final EditText passwordEditText=(EditText)v.findViewById(R.id.passwordEditText);
        final EditText passwordEditText2=(EditText)v.findViewById(R.id.passwordEditText2);
        final EditText nicknameEditText=(EditText)v.findViewById(R.id.nicknameEditText);
        final EditText IDEditText=(EditText)v.findViewById((R.id.IDEditText));
        final EditText phoneEditText=(EditText)v.findViewById(R.id.phoneEditText);
        final EditText emailEditText=(EditText)v.findViewById((R.id.emailEditText));

        Button registerButton=(Button)v.findViewById(R.id.register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=usernameEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                String password2=passwordEditText2.getText().toString();
                String nickname=nicknameEditText.getText().toString();
                String id=IDEditText.getText().toString();
                String phone=phoneEditText.getText().toString();
                String email=emailEditText.getText().toString();

                if(password!=password2){
                    return;
                }

            }
        });
        return v;
    }


}
