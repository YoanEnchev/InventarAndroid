package com.inventar.app.ui.homeActions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inventar.app.R;
import com.inventar.app.data.State;
import com.inventar.app.data.model.Client;
import com.inventar.app.ui.HomeActivity;

public class EditClientActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText familyNameEditText;
    private Button editClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);

        nameEditText = findViewById(R.id.name);
        familyNameEditText = findViewById(R.id.family);
        editClient = findViewById(R.id.edit_client);

        nameEditText.setText(State.openedClient.getName());
        familyNameEditText.setText(State.openedClient.getFamilyName());

        editClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEditText.getText().toString().trim();
                String password = familyNameEditText.getText().toString().trim();

                if (name.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Попълнете име и фамилия.", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}