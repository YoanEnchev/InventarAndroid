package com.inventar.app.ui.homeActions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.inventar.app.R;
import com.inventar.app.data.model.Product;
import com.inventar.app.ui.adapters.ProductAdapter;

import java.util.ArrayList;

public class AvailableProductsActivity extends AppCompatActivity {

    private RecyclerView productsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_products);

        productsRecyclerView = (RecyclerView) findViewById(R.id.products_list);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Син диван", 2020, "ДМА", 2, "Много хубаво описание за диван", true, true));
        products.add(new Product(3, "Италианска Секция", 2020, "ДМА", 3, "Секция от италия", true, false));

        ProductAdapter adapter = new ProductAdapter(products, this);
        productsRecyclerView.setAdapter(adapter);
    }
}