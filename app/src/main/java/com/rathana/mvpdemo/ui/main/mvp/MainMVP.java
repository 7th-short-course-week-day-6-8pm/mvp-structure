package com.rathana.mvpdemo.ui.main.mvp;

import com.rathana.mvpdemo.callback.InteractorResponse;
import com.rathana.mvpdemo.entity.Article;

import java.util.List;

public interface MainMVP {

    interface View{
        void onLoadArticleSuccess(List<Article> articles);
        void onError(String smg);
    }
    interface Presenter{
        void loadArticle(int page,int limit);
        void onDestroy();
        void setView(View view);
    }
    interface Interactor{
        void loadArticle(
                int page,
                int limit,
                InteractorResponse<List<Article>> response);

        void onDestroy();
    }
}
