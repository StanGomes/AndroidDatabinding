package com.example.stan.stansgiftshop.databinding;

import android.util.Log;

import com.example.stan.stansgiftshop.adapter.ProductsAdapter;
import com.example.stan.stansgiftshop.model.Product;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*************************
 *Author : Stanley Gomes *
 *Since : 01/06/2018     *
 *************************/
public class MainFragmentBindingAdapters {

    @BindingAdapter("productList")
    public static void setProductList(RecyclerView recyclerView, List<Product> products){
        if (products == null){
            Log.d("MAINFRAGMENTBINDINGADAPTER", "products is null");
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null){
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        }
        ProductsAdapter productsAdapter = (ProductsAdapter) recyclerView.getAdapter();
        if (productsAdapter == null){
            productsAdapter = new ProductsAdapter(products, recyclerView.getContext());
            recyclerView.setAdapter(productsAdapter);
        }
    }

}
