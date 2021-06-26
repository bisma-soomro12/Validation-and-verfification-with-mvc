package com.example.validationwithmvc.controller;

import com.example.validationwithmvc.model.User;
import com.example.validationwithmvc.view.ILoginView;

public class LoginController implements ILoginContoller{
    // object
    ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String user, String pass) {
        // object of user
        User user1=new User(user,pass);
        int loginCode=user1.isValid();
        if(loginCode==0){
            loginView.onLoginError("please enter user");
        }
        else if(loginCode==1){
            loginView.onLoginError("please enter correct user");
        }
        else if(loginCode==2){
            loginView.onLoginError("please enter password");
        }
        else if(loginCode==3){
            loginView.onLoginError("please enter password greater than 6");
        }
        else{
            loginView.onLoginSuccess("LOGIN SUCCESSFULL");
        }
    }
}
