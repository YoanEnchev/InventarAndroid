package com.inventar.app.ui.homeActions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.inventar.app.R;
import com.inventar.app.data.State;
import com.inventar.app.ui.HomeActivity;

public class ProductEditActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText yearEditText;
    private Spinner typeSpinner;
    private Spinner amorthizationSpinner;
    private EditText descriptionEditText;
    private Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);

        nameEditText = findViewById(R.id.name);
        yearEditText = findViewById(R.id.year);;
        typeSpinner = findViewById(R.id.type);
        amorthizationSpinner = findViewById(R.id.amorthization);
        descriptionEditText = findViewById(R.id.description);
        editBtn = findViewById(R.id.edit_product);

        nameEditText.setText(State.openedProduct.getName());
        yearEditText.setText(State.openedProduct.getYear() + "");
        typeSpinner.setSelection(State.openedProduct.getType().equals("ДМА") ? 0 : 1);
        amorthizationSpinner.setSelection(State.openedProduct.getAmorthizationIndex());
        descriptionEditText.setText(State.openedProduct.getDescription());

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEditText.getText().toString().trim();
                String year = yearEditText.getText().toString().trim();
                String description = descriptionEditText.getText().toString().trim();

                if (name.length() == 0 || year.length() == 0 || description.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Попълнете име, година и описание.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}