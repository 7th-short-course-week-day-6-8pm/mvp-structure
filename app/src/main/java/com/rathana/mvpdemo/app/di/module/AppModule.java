package com.rathana.mvpdemo.app.di.module;

import com.rathana.mvpdemo.data.ServiceGenerator;
import com.rathana.mvpdemo.data.service.ArticleService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private static final String BASE_URL="http://api-ams.me";
    private static  final String API_KEY="QU1TQVBJQURNSU46QU1TQVBJUEBTU1dPUkQ=";

    @Provides
    @Singleton
    public ArticleService provideArticleService(Retrofit retrofit){
        return retrofit.create(ArticleService.class);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        return builder.build();
    }



}
