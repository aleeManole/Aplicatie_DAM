package com.example.aplicatieshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText eRegName;
    private EditText eRegPassword;
    private Button eRegister;
    private Button eClose;

    public static UserModel userModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegister = findViewById(R.id.btnReg);
        eClose = findViewById(R.id.btnClose);


        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel;

                try {
                    userModel = new UserModel(-1, eRegName.getText().toString(), eRegPassword.getText().toString());
                    Toast.makeText(RegistrationActivity.this, "User added", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(RegistrationActivity.this, "Error while register", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "error", "error");
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(RegistrationActivity.this);
                boolean success = dataBaseHelper.addUser(userModel);
                Toast.makeText(RegistrationActivity.this, "Success "+ success, Toast.LENGTH_SHORT).show();
            }
        });

        eClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean Validate(String username, String password) {
        if (username.isEmpty() || password.length() < 8) {
            Toast.makeText(RegistrationActivity.this, "Please complete both fields! Password must have at least 8 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}