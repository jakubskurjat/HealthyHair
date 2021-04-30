package com.example.healthyhair;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SingleProductListAdapter extends ArrayAdapter<Product> {
    private Context mContext;
    private int mResource;

    public SingleProductListAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String date = getItem(position).getTime().substring(0, 10);
        String name = getItem(position).getName();
        String composition = getItem(position).getComposition();
        String productType = getItem(position).getProductType();
        String type = getItem(position).getType();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvName = convertView.findViewById(R.id.tvProductName);
        TextView tvComposition = convertView.findViewById(R.id.productComposition);
        TextView tvProductType = convertView.findViewById(R.id.tvProductType);
        TextView tvType = convertView.findViewById(R.id.tvType);

        tvDate.setText(date);
        tvName.setText(name);
        tvComposition.setText("Composition: " + composition);
        tvProductType.setText(productType);
        tvType.setText(type);

        return convertView;
    }
}