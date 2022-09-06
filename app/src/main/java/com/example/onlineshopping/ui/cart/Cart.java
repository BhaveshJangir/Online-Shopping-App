package com.example.onlineshopping.ui.cart;

import com.example.onlineshopping.ui.home.HomeFragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.onlineshopping.Item;
import com.example.onlineshopping.ItemAdapter;
import com.example.onlineshopping.R;

import java.util.ArrayList;

public class Cart extends Fragment {

    private CartViewModel mViewModel;

    public static Cart newInstance() {
        return new Cart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cart, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        // TODO: Use the ViewModel
    }

}