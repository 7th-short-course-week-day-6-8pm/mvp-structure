package com.rathana.mvpdemo.app.di.module;

import com.rathana.mvpdemo.app.di.scope.ActivityScope;
import com.rathana.mvpdemo.ui.main.mvp.MainInteractor;
import com.rathana.mvpdemo.ui.main.mvp.MainMVP;
import com.rathana.mvpdemo.ui.main.mvp.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

//    @Provides
//    @ActivityScope
//    public MainPresenter provideMainPresenter(MainInteractor interactor){
//        return new MainPresenter(interactor);
//    }

    //provide boject as Super class
    @Provides
    @ActivityScope
    public MainMVP.Presenter provideMainPresenter(MainInteractor interactor){
        return new MainPresenter(interactor);
    }

//    @Provides
//    @ActivityScope
//    public MainInteractor provideMainInteractor(){
//        return new MainInteractor();
//    }

}
