package com.rathana.mvpdemo.callback;

public interface InteractorResponse<T> {

    void onSuccess(T dataResponse);
    void onComplete(String smg);
    void onError(String error);

}
