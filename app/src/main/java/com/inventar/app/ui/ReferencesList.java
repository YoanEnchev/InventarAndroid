package com.inventar.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.inventar.app.R;
import com.inventar.app.ui.homeActions.AvailableProductsActivity;
import com.inventar.app.ui.homeActions.MOLCreationActivity;
import com.inventar.app.ui.homeActions.MissingProductsActivity;
import com.inventar.app.ui.references.DMAProductsActivity;
import com.inventar.app.ui.references.ListAllProductsActivity;
import com.inventar.app.ui.references.MAProductsActivity;
import com.inventar.app.ui.references.TrashedProductsActivity;

public class ReferencesList extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references_list);

        // So onClick function works:
        findViewById(R.id.products_list).setOnClickListener(this);
        findViewById(R.id.dma_products_list).setOnClickListener(this);
        findViewById(R.id.ma_products_list).setOnClickListener(this);
        findViewById(R.id.trashed_products_list).setOnClickListener(this);
        findViewById(R.id.available_products_list).setOnClickListener(this);
        findViewById(R.id.missing_products_list).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.products_list:
                startActivity(new Intent(getApplicationContext(), ListAllProductsActivity.class));
                break;

            case R.id.dma_products_list:
                startActivity(new Intent(getApplicationContext(), DMAProductsActivity.class));
                break;

            case R.id.ma_products_list:
                startActivity(new Intent(getApplicationContext(), MAProductsActivity.class));
                break;

            case R.id.trashed_products_list:
                startActivity(new Intent(getApplicationContext(), TrashedProductsActivity.class));
                break;

            case R.id.available_products_list:
                startActivity(new Intent(getApplicationContext(), AvailableProductsActivity.class));
                break;

            case R.id.missing_products_list:
                startActivity(new Intent(getApplicationContext(), MissingProductsActivity.class));
                break;
        }
    }
}