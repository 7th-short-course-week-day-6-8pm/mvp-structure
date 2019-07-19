package com.rathana.mvpdemo.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rathana.mvpdemo.R;
import com.rathana.mvpdemo.adapter.AmsAdapter;
import com.rathana.mvpdemo.base.BaseActivity;
import com.rathana.mvpdemo.entity.Article;
import com.rathana.mvpdemo.ui.main.mvp.MainMVP;
import com.rathana.mvpdemo.ui.main.mvp.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity
implements MainMVP.View {

    AmsAdapter amsAdapter;
    List<Article> articles=new ArrayList<Article>();
    RecyclerView rvArticle;

    @Inject
    MainMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //presenter= new MainPresenter(this);
        getComponent().inject(this);
        this.presenter.setView(this);

        initUI();
        getData();
    }

    private void initUI(){
        rvArticle=findViewById(R.id.rvArticle);
        rvArticle.setLayoutManager(new LinearLayoutManager(this));
        amsAdapter=new AmsAdapter(articles,this);
        rvArticle.setAdapter(amsAdapter);
    }

    private void getData(){
        presenter.loadArticle(1,20);
    }


    private static final String TAG = "MainActivity";
    @Override
    public void onLoadArticleSuccess(List<Article> articles) {
        amsAdapter.addMoreItems(articles);
        Log.e(TAG, "onLoadArticleSuccess: "+articles );
    }

    @Override
    public void onError(String smg) {
        Log.e(TAG, "onError: "+smg );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
