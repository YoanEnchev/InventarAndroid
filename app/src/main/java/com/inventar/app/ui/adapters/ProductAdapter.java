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
import com.inventar.app.data.model.Product;
import com.inventar.app.ui.HomeActivity;
import com.inventar.app.ui.homeActions.ProductEditActivity;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public ArrayList<Product> products;
    private Context context;

    public ProductAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);

        holder.invNumTextView.setText("Инвентарен номер: " + product.getId());
        holder.nameTextView.setText("Име: " + product.getName());
        holder.typeTextView.setText("Тип: " + product.getType());
        holder.yearTextView.setText("Година: " + product.getYear());
        holder.statusTextView.setText("Статус: " + (product.getIsAvailable() ? "наличен" : "зает от клиент"));

        holder.buttonEditProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                State.openedProduct = product;

                Intent intent = new Intent(context.getApplicationContext(), ProductEditActivity.class);
                context.startActivity(intent);
            }
        });

        if(product.getIsTrashed()) {
            holder.buttonDeleteProduct.setVisibility(View.INVISIBLE);
        }
        else {

            holder.buttonDeleteProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Изтрий", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView invNumTextView;
        public TextView nameTextView;
        public TextView typeTextView;
        public TextView yearTextView;
        public TextView statusTextView;
        public Button buttonEditProduct;
        public Button buttonDeleteProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            invNumTextView = (TextView) itemView.findViewById(R.id.invNumTextView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            typeTextView = (TextView) itemView.findViewById(R.id.typeTextView);
            yearTextView = (TextView) itemView.findViewById(R.id.yearTextView);
            statusTextView = (TextView) itemView.findViewById(R.id.statusTextView);
            buttonEditProduct = (Button) itemView.findViewById(R.id.buttonEditProduct);
            buttonDeleteProduct = (Button) itemView.findViewById(R.id.buttonDeleteProduct);
        }
    }
}