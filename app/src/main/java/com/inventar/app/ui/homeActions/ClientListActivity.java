package com.inventar.app.ui.homeActions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.inventar.app.R;
import com.inventar.app.data.model.Client;
import com.inventar.app.data.model.Product;
import com.inventar.app.ui.adapters.ClientAdapter;
import com.inventar.app.ui.adapters.ProductAdapter;

import java.util.ArrayList;

public class ClientListActivity extends AppCompatActivity {

    private RecyclerView clientsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        clientsRecyclerView = (RecyclerView) findViewById(R.id.clients_list);
        clientsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Иван", "Петров"));
        clients.add(new Client(2, "Стоян", "Димитров"));

        ClientAdapter adapter = new ClientAdapter(clients, this);
        clientsRecyclerView.setAdapter(adapter);
    }
}