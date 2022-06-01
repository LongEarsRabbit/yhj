package com.example.day013.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.day013.R;
import com.example.day013.adapter.BannerAdapter;
import com.example.day013.bean.Banner;
import com.example.day013.databinding.BannerFragmentBinding;
import com.fhz.utilsfhz.ApiResponse;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BannerFragment extends Fragment {

    private BannerViewModel mViewModel;
    private BannerFragmentBinding binding;

    public static BannerFragment newInstance() {
        return new BannerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(BannerViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.banner_fragment, container, false);
        binding.rec.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Banner> bannerList = new ArrayList<>();
        BannerAdapter bannerAdapter = new BannerAdapter(bannerList);
        binding.rec.setAdapter(bannerAdapter);
        //更新数据源
        mViewModel.getBanner().observe(getActivity(), new Observer<ApiResponse<List<Banner>>>() {
            @Override
            public void onChanged(ApiResponse<List<Banner>> listApiResponse) {
                 bannerList.clear();
                 bannerList.addAll(listApiResponse.data);
                 bannerAdapter.notifyDataSetChanged();

                 //存入数据库


            }
        });
        return binding.getRoot();
    }

}