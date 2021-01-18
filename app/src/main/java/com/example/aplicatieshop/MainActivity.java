package com.example.aplicatieshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private EditText eName;
   private EditText ePassword;
   private CheckBox eRememberMe;
   private Button eLogin;
   private Button eCreate;

    private ArrayList<UserModel> allUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eRememberMe = findViewById(R.id.cbRememberMe);
        eLogin = findViewById(R.id.btnLogin);
        eCreate = findViewById(R.id.btnCreate);

        try {
            DataBaseHelper dbHelp = new DataBaseHelper(this);
            allUsers= (ArrayList<UserModel>) dbHelp.selectAll();
        }
        catch (Exception ex) {
            Toast.makeText(this, "Users not loaded.", Toast.LENGTH_SHORT).show();
        }


        eCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, HomePageActivity.class);
                for(int i=0; i<allUsers.size(); i++){
                    if (allUsers.get(i).getUsername().equals(eName.getText().toString()) && allUsers.get(i).getPassword().equals(ePassword.getText().toString()))
                    {
                        Toast.makeText(MainActivity.this, "Successful login", Toast.LENGTH_SHORT).show();
                        intent.putExtra("username", String.valueOf(allUsers.get(i)));
                        startActivity(intent);
                        return;
                    }
                }
                    Toast.makeText(MainActivity.this, "Error while logging", Toast.LENGTH_SHORT).show();
            }
        });
    }

}