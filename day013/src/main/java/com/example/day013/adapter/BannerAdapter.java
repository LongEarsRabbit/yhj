package com.example.day013.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day013.R;
import com.example.day013.bean.Banner;
import com.example.day013.databinding.RecLayoutBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @Date 2022/6/1
 */
public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    private List<Banner> list;

    public BannerAdapter(List<Banner> list) {
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_layout, parent, false);
        RecLayoutBinding bind = DataBindingUtil.bind(view);
        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BannerAdapter.ViewHolder holder, int position) {
        holder.binding.setBanner(list.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RecLayoutBinding binding;
        public ViewHolder(@NonNull @NotNull RecLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    @BindingAdapter("imageUrl")
    public static void setImage(ImageView image,String url){
        Glide.with(image.getContext())
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(image);
    }
}
