package com.inventar.app.ui.homeActions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inventar.app.R;
import com.inventar.app.ui.HomeActivity;

public class TrashProductsActivity extends AppCompatActivity {

    private EditText yearEditText;
    private Button trashBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_products);

        yearEditText = findViewById(R.id.year);
        trashBtn = findViewById(R.id.trash_btn);

        trashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String year = yearEditText.getText().toString().trim();

                if (year.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Попълнете година.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}