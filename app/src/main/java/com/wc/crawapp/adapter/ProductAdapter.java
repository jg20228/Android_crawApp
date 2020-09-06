package com.wc.crawapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wc.crawapp.R;
import com.wc.crawapp.databinding.ContainerItemBinding;
import com.wc.crawapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{
    // 만든 순서 : 내부 클래스 생성 -> Adapter가 extends를 함
    class ProductHolder extends RecyclerView.ViewHolder{

        //gradle에서 databinding을 설정해야한다.
        private ContainerItemBinding containerItemBinding;

        public ProductHolder(@NonNull ContainerItemBinding containerItemBinding) {
            super(containerItemBinding.getRoot());
            this.containerItemBinding = containerItemBinding;
        }
    }

    private List<Product> products = new ArrayList<>();

    public void setProducts(List<Product> products){
        this.products = products;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContainerItemBinding containerItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.container_item,
                parent, //에 붙일것
                false //바로 붙일것인지
        );
        return new ProductHolder(containerItemBinding); //그림을 그려서 던짐
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        //데이터 매칭 시키는곳
        Product product = products.get(position); //현재 위치 값 받음
        holder.containerItemBinding.setProduct(product);
        //아까 만든 <data></data>에 이 값이 들어감
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
