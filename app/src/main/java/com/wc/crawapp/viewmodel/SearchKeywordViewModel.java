package com.wc.crawapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.wc.crawapp.model.SearchKeyword;
import com.wc.crawapp.service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchKeywordViewModel extends AndroidViewModel {

    private static final String TAG = "SearchKeywordViewModel";
    
    private MutableLiveData<List<SearchKeyword>> mtSearchKeywords =
            new MutableLiveData<>();

    public SearchKeywordViewModel(@NonNull Application application) {
        super(application);
    }

    //데이터 변경 감지
    public MutableLiveData<List<SearchKeyword>> 구독(){
        return mtSearchKeywords;
    }

    //초기에 데이터를 등록해줌 (그리고 변경 감지시 '구독'을 실행)
    public void 데이터등록(){
        //이해가 필요한 곳이 아닌 문법이다.
        Call<List<SearchKeyword>> call =
                RetrofitService.retrofit.create(RetrofitService.class).callKeywords();
        call.enqueue(new Callback<List<SearchKeyword>>() {
            @Override
            public void onResponse(Call<List<SearchKeyword>> call, Response<List<SearchKeyword>> response) {
                List<SearchKeyword> searchKeywords = response.body();
                mtSearchKeywords.setValue(searchKeywords);
            }

            @Override
            public void onFailure(Call<List<SearchKeyword>> call, Throwable t) {
                Log.d(TAG, "onFailure: 통신 실패");
            }
        });
        //mtSearchKeywords.setValue(searchKeywords);
    }
    //한개만 추가하고 한개만 삭제하는 함수도 있어야한다.
}
