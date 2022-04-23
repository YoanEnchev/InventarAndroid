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

public class MOLCreationActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button molCreationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_molcreation);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        molCreationButton = findViewById(R.id.mol_creation_btn);

        molCreationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Попълнете име и парола.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // TODO

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}