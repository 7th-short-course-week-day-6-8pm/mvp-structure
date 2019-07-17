package com.rathana.mvpdemo.ui.login.mvp;

public class LoginPresenter implements LoginMVP.Presenter {

    private LoginMVP.Interactor interactor;
    private LoginMVP.View view;

    public LoginPresenter() {
        //todo create object interactor
        this.interactor = new LoginInteractor();
    }

    @Override
    public void onLogin(String userName, String password) {
        if(view!=null)
            view.onShowLoading();

        interactor.authenticate(userName, password, new LoginMVP.Interactor.InterctorResponse() {
            @Override
            public void onSuccess(String message) {
                if(view!=null){
                    view.onLoginSuccess(message);
                    view.onHideLoading();
                }
            }

            @Override
            public void onError(String message) {
                if(view!=null){
                    view.onLoginFail(message);
                    view.onHideLoading();
                }
            }
        });
    }

    @Override
    public void setView(LoginMVP.View view) {
        this.view=view;
    }
}
