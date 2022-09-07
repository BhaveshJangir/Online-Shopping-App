package com.example.onlineshopping.ui.account;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineshopping.MainActivity;
import com.example.onlineshopping.R;
import com.example.onlineshopping.User;
import com.example.onlineshopping.databinding.FragmentAccountBinding;
import com.example.onlineshopping.ui.home.HomeFragment;

public class Account extends Fragment {

    private FragmentAccountBinding binding;
    //private AccountViewModel mViewModel;

    public static Account newInstance() {
        return new Account();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account,container,false);

        ImageView mProfile = (ImageView) rootView.findViewById(R.id.profile_info);
        TextView mUsernameTv = (TextView) rootView.findViewById(R.id.username_info);
        TextView mEmailTv = (TextView) rootView.findViewById(R.id.email_info_tv);
        EditText mUsername = (EditText) rootView.findViewById(R.id.name_info_et);
        EditText mEmail = (EditText) rootView.findViewById(R.id.email_info_et);
        EditText mMobile = (EditText) rootView.findViewById(R.id.mobile_info_et);
        EditText mAddress = (EditText) rootView.findViewById(R.id.address_info_et);
        Button mBackBt = (Button) rootView.findViewById(R.id.back_bt);

        mBackBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(), MainActivity.class);
                startActivity(i);
            }
        });
        return rootView;
    }


}