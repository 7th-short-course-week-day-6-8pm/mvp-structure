package com.rathana.mvpdemo.app.di.component;

import android.app.Application;

import com.rathana.mvpdemo.app.di.module.AppModule;
import com.rathana.mvpdemo.data.service.ArticleService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(Application application);

    ArticleService getArticleService();

}
