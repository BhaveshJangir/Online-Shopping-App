package com.example.onlineshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(@NonNull Context context,  @NonNull ArrayList<Item> objects) {
        super(context, 0, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,false);
        }
        Item currentItem = getItem(position);

        TextView brand = (TextView) listItemView.findViewById(R.id.item_brand);
        brand.setText(currentItem.getBrand());

        TextView itemName = (TextView) listItemView.findViewById(R.id.item_name);
        itemName.setText(currentItem.getName());

        TextView itemPrice = (TextView) listItemView.findViewById(R.id.item_price);
        itemPrice.setText("RS. "+currentItem.getPrice());

        ImageView itemImage = (ImageView) listItemView.findViewById(R.id.item_image);
        if(currentItem.hasImage()){
            itemImage.setImageResource(currentItem.getmImageResourceId());
            itemImage.setVisibility(View.VISIBLE);
        }
//        else{
//            itemImage.setVisibility(View.GONE);
//        }
//        ImageView cartImage = (ImageView) listItemView.findViewById(R.id.cart_image);
//        cartImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cartImage.setImageResource(currentItem.getmImageResourceId());
//            }
//        });

        return listItemView;
    }
}
