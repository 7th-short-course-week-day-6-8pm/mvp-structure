package com.rathana.mvpdemo.ui.main.mvp;

import com.rathana.mvpdemo.callback.InteractorResponse;
import com.rathana.mvpdemo.entity.Article;

import java.util.List;

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;

    private MainMVP.Interactor interactor;


    public MainPresenter(MainMVP.View view, MainMVP.Interactor interactor) {
        this.view = view;
        //interactor =new MainInteractor();
        this.interactor=interactor;
    }

    @Override
    public void loadArticle(int page, int limit) {
        interactor.loadArticle(page, limit, new InteractorResponse<List<Article>>() {
            @Override
            public void onSuccess(List<Article> dataResponse) {
                view.onLoadArticleSuccess(dataResponse);
                //hide loading here!!!
            }

            @Override
            public void onComplete(String smg) { }

            @Override
            public void onError(String error) {
                view.onError(error);
            }
        });
    }

    @Override
    public void onDestroy() {
        interactor.onDestroy();
    }
}
