package com.example.hh.fangyan2.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

    private static OkHttpClient okHttpClient=new OkHttpClient();
    public static final String BASE_URL="http://47.93.23.231/fangyanshibie";


    public static Response doGet(String url){
        Request request = new Request.Builder()
                .url(BASE_URL+url)
                .get()
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response doPost(String url) {
        FormBody.Builder formBody = new FormBody.Builder();
        Request request = new Request.Builder()
                .url(BASE_URL+url)
                .post(formBody.build())
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response doPost(String url,File file,String mediaType){
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse(mediaType), file));

        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(BASE_URL+url)
                .post(requestBody)
                .build();
        try {
            Response response= okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response doPost(String url,Map<String,String> params, File file,String mediaType){
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse(mediaType), file));
        for(String s:params.keySet()){
            builder.addFormDataPart(s,params.get(s));
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(BASE_URL+url)
                .post(requestBody)
                .build();
        try {
            Response response= okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static Response doPost(String url, Map<String,String> params){
        FormBody.Builder formBody = new FormBody.Builder();
        for(String s:params.keySet()){
            formBody.add(s,params.get(s));
        }
        Request request = new Request.Builder()
                .url(BASE_URL+url)
                .post(formBody.build())
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Response doGet(String url, Map<String,String> params){
        url=url+"?_=0";
        for(String s:params.keySet()){
            url=url+"&"+s+"="+params.get(s);
        }
        Request request = new Request.Builder()
                .url(BASE_URL+url)
                .get()
                .build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
