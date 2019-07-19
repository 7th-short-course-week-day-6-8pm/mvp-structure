package com.rathana.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rathana.mvpdemo.app.MyApp;
import com.rathana.mvpdemo.app.di.component.ActivityComponent;
import com.rathana.mvpdemo.app.di.component.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        component = DaggerActivityComponent.builder()
                .appComponent(((MyApp) getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getComponent() {
        return component;
    }
}
