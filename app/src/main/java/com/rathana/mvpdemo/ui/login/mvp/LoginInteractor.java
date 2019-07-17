package com.rathana.mvpdemo.ui.login.mvp;

import android.os.Handler;

///connect toward to getway > retrofit , Room persistence, fireBase
public class LoginInteractor implements LoginMVP.Interactor {

    private static final String DEFAULT_USER_NAME="admin";
    private static final String DEFAULT_USER_PASSWORD="admin";


    public LoginInteractor() {
        //449d05e6b6284b59a317f89b6b9b7c82
    }

    @Override
    public void authenticate(String userName, String password,
                             InterctorResponse response) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                authenticateLogin(userName,password,response);
            }
        },2000);

    }

    private void authenticateLogin(String name,String pass, InterctorResponse response){
        if(DEFAULT_USER_NAME.equals(name)
                &&  DEFAULT_USER_PASSWORD.equals(pass)){
            response.onSuccess("login success");

        }else{
            response.onError("login fail");
        }

    }
}
