package com.example.validationwithmvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.validationwithmvc.controller.LoginController;
import com.example.validationwithmvc.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText txt_user,txt_pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginController loginController= new LoginController(this);
        txt_user=(EditText)findViewById(R.id.user);
        txt_pass=(EditText)findViewById(R.id.pass);
        btn=(Button)findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginController.onLogin(txt_user.getText().toString().trim(),txt_pass.getText().toString().trim());
            }
        });
    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}