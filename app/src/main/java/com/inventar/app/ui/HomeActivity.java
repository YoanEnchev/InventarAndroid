package com.inventar.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.inventar.app.R;
import com.inventar.app.data.State;
import com.inventar.app.ui.homeActions.ClientListActivity;
import com.inventar.app.ui.homeActions.MOLCreationActivity;
import com.inventar.app.ui.homeActions.ProductCreationActivity;
import com.inventar.app.ui.homeActions.RegisterClientActivity;
import com.inventar.app.ui.homeActions.TrashProductsActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // So onClick function works:
        findViewById(R.id.create_mol).setOnClickListener(this);
        findViewById(R.id.create_product).setOnClickListener(this);
        findViewById(R.id.create_client).setOnClickListener(this);
        findViewById(R.id.trash_old).setOnClickListener(this);
        findViewById(R.id.clients_list).setOnClickListener(this);
        findViewById(R.id.references).setOnClickListener(this);

        if(!State.loggedInRole.equals("admin")) {
            findViewById(R.id.create_mol).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.create_mol:
                startActivity(new Intent(getApplicationContext(), MOLCreationActivity.class));
                break;

            case R.id.create_product:
                startActivity(new Intent(getApplicationContext(), ProductCreationActivity.class));
                break;

            case R.id.create_client:
                startActivity(new Intent(getApplicationContext(), RegisterClientActivity.class));
                break;

            case R.id.trash_old:
                startActivity(new Intent(getApplicationContext(), TrashProductsActivity.class));
                break;

            case R.id.clients_list:
                startActivity(new Intent(getApplicationContext(), ClientListActivity.class));
                break;

            case R.id.references:
                startActivity(new Intent(getApplicationContext(), ReferencesList.class));
                break;
        }
    }
}