package com.rathana.mvpdemo.ui.login.mvp;

public interface LoginMVP {

    //View -> Activity/Fragment
    interface View {
        void onShowLoading();
        void onHideLoading();
        void onLoginSuccess(String message);
        void onLoginFail(String message);
    }

    //presenter
    interface Presenter{
        void onLogin(String userName,String password);
        void setView(View view);
    }

    //Model
    interface Interactor{
        void authenticate(String userName,String password,InterctorResponse response);

        interface InterctorResponse{
            void onSuccess(String message);
            void onError(String message);
        }
    }


}
