package com.example.csl_1.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.csl_1.product.Product;
import com.example.csl_1.product.R;

import java.util.ArrayList;

/**
 * Created by csl_1 on 11-Jul-16.
 */
public class ProductAdapter extends ArrayAdapter {
    ArrayList<Product> productList;
    Context context;
    TextView nameTV;
    TextView priceTV;


    public ProductAdapter(Context context,  ArrayList<Product> productList) {
        super(context, R.layout.row_layout,productList);
        this.productList=productList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView;

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView= inflater.inflate(R.layout.row_layout,parent,false);

        nameTV=(TextView)rowView.findViewById(R.id.nameTV);
        priceTV=(TextView)rowView.findViewById(R.id.priceTV);

        nameTV.setText(productList.get(position).getName());
        priceTV.setText(productList.get(position).getPrice());


        return rowView;
    }
}
