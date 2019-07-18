package com.rathana.mvpdemo.ui.main.mvp;

import com.rathana.mvpdemo.callback.InteractorResponse;
import com.rathana.mvpdemo.data.ServiceGenerator;
import com.rathana.mvpdemo.data.service.ArticleService;
import com.rathana.mvpdemo.entity.Article;
import com.rathana.mvpdemo.entity.ArticleResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainInteractor implements MainMVP.Interactor {

    //todo create object Article service

    ArticleService articleService;

    private CompositeDisposable disposable=new CompositeDisposable();
    public MainInteractor() {
        articleService= ServiceGenerator.createService(ArticleService.class);
    }

    @Override
    public void loadArticle(int page, int limit, InteractorResponse<List<Article>> response) {
        //get article
        disposable.add(articleService.getArticleWithRx(page,limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<ArticleResponse>() {
                    @Override
                    public void onNext(ArticleResponse articleResponse) {
                        response.onSuccess(articleResponse.getArticles());
                    }

                    @Override
                    public void onError(Throwable t) {
                        response.onError(t.toString());
                    }

                    @Override
                    public void onComplete() {
                        response.onComplete("get article complete");
                    }
                }));

    }

    @Override
    public void onDestroy(){
        disposable.clear();
    }
}
