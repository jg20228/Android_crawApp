package com.wc.crawapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.wc.crawapp.adapter.ProductAdapter;
import com.wc.crawapp.adapter.SearchKeywordAdapter;
import com.wc.crawapp.model.Product;
import com.wc.crawapp.model.SearchKeyword;
import com.wc.crawapp.viewmodel.SearchKeywordViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivity mContext = MainActivity.this;
    private RecyclerView rvMenu, rvContainer;
    private SearchKeywordAdapter searchKeywordAdapter;
    private ProductAdapter productAdapter;
    private SearchKeywordViewModel searchKeywordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObject();
        initSetting();
        //sampleData();
        initData();
    }

    private void initObject(){
        rvMenu = findViewById(R.id.rv_menu);
        rvContainer = findViewById(R.id.rv_container);

        searchKeywordAdapter = new SearchKeywordAdapter();
        productAdapter = new ProductAdapter();

        searchKeywordViewModel = ViewModelProviders.of(mContext).get(SearchKeywordViewModel.class);
    }

    private void initSetting(){
        //여기서 어댑터 셋팅할것이다. (컨텍스트,방향,반전할것인지)
        rvMenu.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false));
        rvContainer.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false));

        //연결끝
        rvMenu.setAdapter(searchKeywordAdapter);
        rvContainer.setAdapter(productAdapter);
    }

    private void initData(){
        searchKeywordViewModel.데이터등록();
        searchKeywordViewModel.구독().observe(mContext, new Observer<List<SearchKeyword>>() {
            @Override
            public void onChanged(List<SearchKeyword> searchKeywords) {
                searchKeywordAdapter.setSearchKeywords(searchKeywords);
                searchKeywordAdapter.notifyDataSetChanged();
            }
        });
    }

    //테스트 용도
    private void sampleData(){
        List<SearchKeyword> searchKeywords = new ArrayList<>();
        searchKeywords.add(new SearchKeyword(1,"갤럭시20"));
        searchKeywords.add(new SearchKeyword(2,"아이폰12"));
        searchKeywords.add(new SearchKeyword(3,"맥북프로"));
        searchKeywords.add(new SearchKeyword(4,"아이폰11"));
        searchKeywordAdapter.setSearchKeywords(searchKeywords);

        List<Product> products = new ArrayList<>();
        products.add(Product.builder().title("제목1").day("1일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목2").day("2일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://pgnqdrjultom1827145.cdn.ntruss.com/img/de/8a/de8acb0b3ec140dd2cd53806cbd29cf204be769bd51f8e189a60a58c010f5b93_v1.jpg").build());
        productAdapter.setProducts(products);
    }
}