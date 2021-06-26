package com.example.validationwithmvc.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements ILogin {
    private String user, password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValid() {
        if (TextUtils.isEmpty(getUser())) {
            return 0;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(getUser()).matches()) {
            return 1;
        }
        else if(TextUtils.isEmpty(getPassword())){
            return 2;
        }
        else if(getPassword().length()<=6){
            return 3;
        }
        else{
            return -1;
        }


    }
}
