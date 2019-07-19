package com.rathana.mvpdemo.app.di.component;

import android.app.Application;

import com.rathana.mvpdemo.app.di.module.ActivityModule;
import com.rathana.mvpdemo.app.di.scope.ActivityScope;
import com.rathana.mvpdemo.ui.login.LoginActivity;
import com.rathana.mvpdemo.ui.main.MainActivity;
import com.rathana.mvpdemo.ui.main.mvp.MainMVP;

import javax.inject.Singleton;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class},
dependencies = {AppComponent.class})
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(LoginActivity activity);

    //MainMVP.Presenter getMainPresenter();
}
