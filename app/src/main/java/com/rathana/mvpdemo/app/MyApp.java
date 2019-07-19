package com.rathana.mvpdemo.app;

import android.app.Application;

import com.rathana.mvpdemo.app.di.component.AppComponent;
import com.rathana.mvpdemo.app.di.component.DaggerAppComponent;

public class MyApp extends Application {

    private AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();

        component= DaggerAppComponent.builder().build();
        component.inject(this);
    }

    public AppComponent getComponent() {
        return component;
    }
}
