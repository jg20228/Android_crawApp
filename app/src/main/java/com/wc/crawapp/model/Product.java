package com.wc.crawapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.wc.crawapp.R;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private int id;
    private String blogUrl;
    private String title;
    private String thumnail;
    private String day;
    private SearchKeyword keywords;
    private Timestamp createDate;

    @BindingAdapter({"thumnail"}) //thumnail을 호출하면 return을 해주는게 아니라 데이터가 꼽힘
    public static void loadImage(ImageView view, String thumnail){
        Glide.with(view.getContext())
                .load(thumnail)
                .error(R.drawable.ic_default) //에러 났을대 사진
                .placeholder(R.color.colorAccent)
                .into(view);
    }
}
