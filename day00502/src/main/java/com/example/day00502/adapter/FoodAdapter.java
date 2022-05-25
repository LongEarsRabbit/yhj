package com.example.day00502.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.day00502.R;
import com.example.day00502.bean.FoodBean;
import com.example.day00502.databinding.ItemFoodBinding;


import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @Date 2022/5/23
 */
public class FoodAdapter extends BaseQuickAdapter<FoodBean.DataDTO, BaseViewHolder> {

    private ItemFoodBinding binding;

    public FoodAdapter(@Nullable List<FoodBean.DataDTO> data) {
        super(R.layout.item_food, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, FoodBean.DataDTO dataDTO) {
        binding.setFood(dataDTO);
    }

    @Override
    public @NotNull BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        binding = DataBindingUtil.bind(inflate);
        return new BaseViewHolder(binding.getRoot());

    }
    @BindingAdapter("imageUrl")
    public static void setImage(ImageView image,String url){
        Glide.with(image.getContext())
                .load(url)
                .into(image);
    }
}
