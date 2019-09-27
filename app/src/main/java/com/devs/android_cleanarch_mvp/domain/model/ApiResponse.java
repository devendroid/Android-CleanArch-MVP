package com.devs.android_cleanarch_mvp.domain.model;

/**
 * Created by Deven on 2019-09-27.
 */
public class ApiResponse<T> {
    private T body;
    private int code;
    private String message;


    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
