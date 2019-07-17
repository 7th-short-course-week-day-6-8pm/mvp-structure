package com.rathana.mvpdemo.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rathana.mvpdemo.R;
import com.rathana.mvpdemo.ui.login.mvp.LoginMVP;
import com.rathana.mvpdemo.ui.login.mvp.LoginPresenter;
import com.rathana.mvpdemo.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity
implements LoginMVP.View {

    EditText edUserName ,edPassword;
    Button btnLogin;
    ProgressBar progressBar;
    private LoginMVP.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edPassword=findViewById(R.id.edPasswod);
        edUserName=findViewById(R.id.edUserName);
        btnLogin=findViewById(R.id.btnLogin);
        progressBar=findViewById(R.id.progressBar);

        presenter=new LoginPresenter();
        presenter.setView(this);

        btnLogin.setOnClickListener(v->{

            String username=edUserName.getText().toString();
            String password=edPassword.getText().toString();
            presenter.onLogin(username,password);

        });
    }

    @Override
    public void onShowLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoginSuccess(String message) {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }
}
