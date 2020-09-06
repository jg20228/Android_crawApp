package com.wc.crawapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wc.crawapp.R;
import com.wc.crawapp.databinding.MenuItemBinding;
import com.wc.crawapp.model.Product;
import com.wc.crawapp.model.SearchKeyword;
import com.wc.crawapp.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchKeywordAdapter extends RecyclerView.Adapter<SearchKeywordAdapter.SearchKeyHolder>{

    private static final String TAG = "SearchKeywordAdapter";

    private ProductViewModel productViewModel;

    public SearchKeywordAdapter() {
    }

    public SearchKeywordAdapter(ProductViewModel productViewModel) {
        this.productViewModel = productViewModel;
    }

    class SearchKeyHolder extends RecyclerView.ViewHolder{

        private MenuItemBinding menuItemBinding;

        public SearchKeyHolder(@NonNull MenuItemBinding menuItemBinding) {
            super(menuItemBinding.getRoot()); //View 타입으로 바뀜
            this.menuItemBinding = menuItemBinding;
        }
    }
    private List<SearchKeyword> searchKeywords = new ArrayList<>();

    public void setSearchKeywords(List<SearchKeyword> searchKeywords){
        //그림 만드는곳
        this.searchKeywords = searchKeywords;
    }

    @NonNull
    @Override
    public SearchKeyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MenuItemBinding menuItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.menu_item,
                parent,
                false
        );
        return new SearchKeyHolder(menuItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchKeyHolder holder, int position) {
        //데이터 매칭시키는것
        //holder에다가 데이터를 넣어주기만 하면된다.
        SearchKeyword searchKeyword = searchKeywords.get(position); //현재 위치에 있는 값을 받음
        holder.menuItemBinding.setSearchKeyword(searchKeyword);//아까 만든 <data></data>에 이 값이 들어감
        holder.menuItemBinding.setProductViewModel(productViewModel);
    }

    @Override
    public int getItemCount() {
        return searchKeywords.size();
    }

}
