package com.inventar.app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inventar.app.R;
import com.inventar.app.data.model.Product;

import java.util.ArrayList;

public class OwnedProductAdapter extends RecyclerView.Adapter<OwnedProductAdapter.ViewHolder> {

    public ArrayList<Product> ownedProducts;
    private Context context;

    public OwnedProductAdapter(ArrayList<Product> ownedProducts, Context context) {
        this.ownedProducts = ownedProducts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.owned_product_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Product product = ownedProducts.get(position);

        holder.productIDTextView.setText("ИД: " + product.getId());
        holder.productNameTextView.setText(product.getName());
        holder.removeProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Премахване на продукти", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ownedProducts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productIDTextView;
        public TextView productNameTextView;
        public Button removeProdBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productIDTextView = (TextView) itemView.findViewById(R.id.productIDTextView);
            productNameTextView = (TextView) itemView.findViewById(R.id.productNameTextView);
            removeProdBtn = (Button) itemView.findViewById(R.id.removeProdBtn);
        }
    }
}