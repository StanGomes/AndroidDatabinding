package com.example.stan.stansgiftshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stan.stansgiftshop.R;
import com.example.stan.stansgiftshop.databinding.ProductItemBinding;
import com.example.stan.stansgiftshop.model.Product;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/*************************
 *Author : Stanley Gomes *
 *Since : 01/06/2018     *
 *************************/
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.BindingHolder> {

    private static final String TAG = "ProductsAdapter";

    private List<Product> productList = new ArrayList<>();
    private Context context;

    public ProductsAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductsAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding productItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_item, parent, false);
        return new BindingHolder(productItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.BindingHolder holder, int position) {
        Product product = productList.get(position);
        holder.productItemBinding.setProduct(product);
        holder.productItemBinding.executePendingBindings();
        holder.productItemBinding.setProductClickListener((ProductClickListener) context);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void refreshList(List<Product> products){
        productList.clear();
        productList.addAll(products);
        notifyDataSetChanged();
    }

    public class BindingHolder extends RecyclerView.ViewHolder {

        ProductItemBinding productItemBinding;

        public BindingHolder(@NonNull View itemView) {
            super(itemView);
            productItemBinding = DataBindingUtil.bind(itemView);
        }
    }
}
