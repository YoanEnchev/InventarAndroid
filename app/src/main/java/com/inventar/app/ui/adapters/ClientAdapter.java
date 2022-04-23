package com.inventar.app.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inventar.app.R;
import com.inventar.app.data.State;
import com.inventar.app.data.model.Client;
import com.inventar.app.data.model.Product;
import com.inventar.app.ui.ReferencesList;
import com.inventar.app.ui.homeActions.ClientDetailsActivity;
import com.inventar.app.ui.homeActions.EditClientActivity;

import java.util.ArrayList;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    public ArrayList<Client> clients;
    private Context context;

    public ClientAdapter(ArrayList<Client> clients, Context context) {
        this.clients = clients;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.client_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Client client = clients.get(position);

        holder.clientIDTextView.setText("ИД: " + client.getId());
        holder.clientNameTextView.setText(client.getName() + " " + client.getFamilyName());
        holder.viewDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Виж детайки", Toast.LENGTH_LONG).show();

                context.startActivity(new Intent(context, ClientDetailsActivity.class));
            }
        });

        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Редактиране", Toast.LENGTH_LONG).show();

                State.openedClient = client;
                context.startActivity(new Intent(context, EditClientActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView clientIDTextView;
        public TextView clientNameTextView;
        public Button viewDetailsBtn;
        public Button editBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            clientIDTextView = (TextView) itemView.findViewById(R.id.clientIDTextView);
            clientNameTextView = (TextView) itemView.findViewById(R.id.clientNameTextView);
            viewDetailsBtn = (Button) itemView.findViewById(R.id.viewDetailsBtn);
            editBtn = (Button) itemView.findViewById(R.id.editBtn);
        }
    }
}