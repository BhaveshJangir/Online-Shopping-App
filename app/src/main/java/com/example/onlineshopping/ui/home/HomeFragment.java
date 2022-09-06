package com.example.onlineshopping.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineshopping.Item;
import com.example.onlineshopping.ItemAdapter;
import com.example.onlineshopping.R;
import com.example.onlineshopping.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Item> item  = new ArrayList<Item>();
        item.add(new Item("Good","Sport Bottle ed4","700",R.drawable.bottle_item));
        item.add(new Item("Mockup bottles","bt2 edition combo tree","1499",R.drawable.bottle_tree));
        item.add(new Item("LEVI'S","Blue shirt sh-one","1999",R.drawable.blue_shirt));
        item.add(new Item("LEVI'S","Dark jeans shirt edition","2499",R.drawable.blue_shirt_two));
        item.add(new Item("MOCKUP SHIRTS","Red shirt merhi-4","1799",R.drawable.red_shirt));
        item.add(new Item("MOCKUP T-SHIRTS","White t-shirt edt-1","999",R.drawable.white_tshirt));
        item.add(new Item("MOCKUP T-SHIRTS","White mens t-shirt combo","1899",R.drawable.white_tshirt_combo));
        item.add(new Item("MOCKUP T-SHIRTS","black mens t-shirt","799",R.drawable.black_tshirt));
        item.add(new Item("MOCKUP WATCH","Smartwatch S new edition","3999",R.drawable.smart_watch));
        item.add(new Item("MOCKUP WATCH","smart band new edition","2599",R.drawable.smartwatch_band));
        item.add(new Item("MOCKUP WATCH","smartwatch z new edition","4599",R.drawable.smartwatch_mockup));


        ItemAdapter itemAdapter = new ItemAdapter(getActivity(),item);
        ListView listView = (ListView) rootView.findViewById(R.id.home_listView);
        listView.setAdapter(itemAdapter);




//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}