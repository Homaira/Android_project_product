package com.example.csl_1.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.csl_1.product.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    EditText priceET;
    Product product;
    ProductManager manager;
    ListView listview;
    ProductAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = (EditText) findViewById(R.id.nameET);
        priceET = (EditText) findViewById(R.id.priceET);
        listview= (ListView) findViewById(R.id.listView);

        manager = new ProductManager(MainActivity.this);
        product = new Product();
    }

    public void saveContact(View view) {

        String name = nameET.getText().toString();
        String price = priceET.getText().toString();
        product.setName(name);
        product.setPrice(price);

        boolean inserted = manager.addProduct(product);

        if (inserted) {
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }

        ArrayList<Product> allProduct=manager.getAllProduct();


//        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,allContact);

        adapter = new ProductAdapter(this,allProduct);

        listview.setAdapter(adapter);

        Toast.makeText(MainActivity.this, allProduct.get(0).getName(), Toast.LENGTH_SHORT).show();

    }
}
