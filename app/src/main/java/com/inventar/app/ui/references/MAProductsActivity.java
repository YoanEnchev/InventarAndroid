package com.inventar.app.ui.references;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.inventar.app.R;
import com.inventar.app.data.model.Product;
import com.inventar.app.ui.adapters.ProductAdapter;

import java.util.ArrayList;

public class MAProductsActivity extends AppCompatActivity {

    private RecyclerView productsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maproducts);


        productsRecyclerView = (RecyclerView) findViewById(R.id.products_list);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(2, "Дървен Шкаф", 2021, "МА", 4, "Много хубаво описание за шкаф", false, true));
        products.add(new Product(4, "Легло с мека пяна", 2018, "МА", 1, "Легло с мека пяна", true, false));
        products.add(new Product(5, "Немски Стол", 2022, "МА", 5, "Стол произведен в Германия.", true, true));



        ProductAdapter adapter = new ProductAdapter(products, this);
        productsRecyclerView.setAdapter(adapter);
    }
}