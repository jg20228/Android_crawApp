package com.wc.crawapp.service;

import com.wc.crawapp.model.Product;
import com.wc.crawapp.model.SearchKeyword;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("/searchKeyword")
    Call<List<SearchKeyword>> callKeywords();

    @GET("/product/{keyword}")
    Call<List<Product>> callProductByKeyword(@Path("keyword") int keywordId);
    //키워드를 던지고 그 키워드로 findByKeyword해서 던져야함

    @GET("/product")
    Call<List<Product>> callProducts();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.219.104:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
