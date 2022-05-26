package com.example.day007.adapter;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.day007.R;
import com.example.day007.bean.Food;
import com.example.day007.dao.FoodDataBase;
import com.example.day007.databinding.ItemShowBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @Date 2022/5/26
 */
public class FoodShowAdapter extends BaseQuickAdapter<Food, BaseViewHolder> {

    public FoodShowAdapter(int layoutResId, @Nullable List<Food> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Food food) {
        ItemShowBinding binding = baseViewHolder.getBinding();
        binding.setData(food);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            private AlertDialog alertDialog;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setNegativeButton("取消", (dialog, which) -> alertDialog.dismiss());
                builder.setPositiveButton("确认", (dialog, which) -> {
                    alertDialog.dismiss();

                    int i = FoodDataBase.getInstance().foodDao().selectIsCun(food.getId() + "");
                    if(i != 0){
                        Toast.makeText(getContext(), "已存在", Toast.LENGTH_SHORT).show();
                    }else{
                        FoodDataBase.getInstance().foodDao().addFood(food);
                        Toast.makeText(getContext(), "存到数据库了", Toast.LENGTH_SHORT).show();
                    }

                });
                builder.setTitle("是否存到数据库");
                builder.setIcon(R.mipmap.ic_launcher);
                alertDialog = builder.create();
                alertDialog.show();
            }
        });
        baseViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            private AlertDialog alertDialog;
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setNegativeButton("取消", (dialog, which) -> alertDialog.dismiss());
                builder.setPositiveButton("确认", (dialog, which) -> {
                    alertDialog.dismiss();
                    int i = FoodDataBase.getInstance().foodDao().selectIsCun(food.getId() + "");
                    if(i != 0){
                        FoodDataBase.getInstance().foodDao().deleteById(food);
                        Toast.makeText(getContext(), "已删除", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "数据库没有此数据", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setTitle("是否删除数据库数据");
                builder.setIcon(R.mipmap.ic_launcher);
                alertDialog = builder.create();
                alertDialog.show();
                return true;
            }
        });

    }

    @Override
    public @NotNull BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show, parent,false);
        ItemShowBinding binding = DataBindingUtil.bind(inflate);
        return new BaseViewHolder(binding.getRoot());
    }

    @BindingAdapter("image")
    public static void createImage(ImageView imageView,String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
