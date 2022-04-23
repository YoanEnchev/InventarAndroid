package com.inventar.app.ui.homeActions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.inventar.app.R;
import com.inventar.app.data.model.Product;
import com.inventar.app.ui.HomeActivity;
import com.inventar.app.ui.adapters.OwnedProductAdapter;
import com.inventar.app.ui.adapters.ProductAdapter;

import java.util.ArrayList;

public class ClientDetailsActivity extends AppCompatActivity {

    private RecyclerView ownedProductsRecyclerView;
    private Spinner rentProductSpinner;
    private Button rentProductBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_details);

        ownedProductsRecyclerView = (RecyclerView) findViewById(R.id.ownedProductsList);
        ownedProductsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Син диван", 2020, "ДМА", 2, "Много хубаво описание за диван", true, true));
        products.add(new Product(3, "Италианска Секция", 2020, "ДМА", 3, "Секция от италия", false, false));

        OwnedProductAdapter adapter = new OwnedProductAdapter(products, this);
        ownedProductsRecyclerView.setAdapter(adapter);

        rentProductSpinner = (Spinner) findViewById(R.id.rentProductSpinner);

        String spinnerProducts[] = {"2 - Дървен Шкаф", "4 - Легло с мека пяна", "5 - Немски Стол"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_dropdown_item, spinnerProducts);
        rentProductSpinner.setAdapter(spinnerArrayAdapter);


        rentProductBtn = (Button) findViewById(R.id.rentProductBtn);
        rentProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Наеми", Toast.LENGTH_LONG).show();

                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });
    }
}