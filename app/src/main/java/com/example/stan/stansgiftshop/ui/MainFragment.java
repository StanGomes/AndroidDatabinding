package com.example.stan.stansgiftshop.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stan.stansgiftshop.adapter.ProductsAdapter;
import com.example.stan.stansgiftshop.databinding.FragmentMainBinding;
import com.example.stan.stansgiftshop.model.Product;
import com.example.stan.stansgiftshop.util.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private static MainFragment newInstance;
    //Data binding
    private FragmentMainBinding fragmentMainBinding;

    public static synchronized MainFragment getNewInstance(){
        if (newInstance == null){
            newInstance = new MainFragment();
        }
        return newInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMainBinding = FragmentMainBinding.inflate(inflater);
        fragmentMainBinding.swipeRefreshLayout.setOnRefreshListener(this);

        initRecyclerView();

        return fragmentMainBinding.getRoot();
    }

    @Override
    public void onRefresh() {
        Products products = new Products();
        List<Product> productList = new ArrayList<>(Arrays.asList(products.PRODUCTS));
        ((ProductsAdapter)fragmentMainBinding.productRv.getAdapter()).refreshList(productList);
        onItemsLoaded();
    }

    private void initRecyclerView(){
        Products products = new Products();
        List<Product> productList = new ArrayList<>(Arrays.asList(products.PRODUCTS));
        fragmentMainBinding.setProducts(productList);
    }

    private void onItemsLoaded() {
        fragmentMainBinding.productRv.getAdapter().notifyDataSetChanged();
        fragmentMainBinding.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDetach() {
        Log.d("MainFragment" , "onDetach called");
        super.onDetach();
    }


}
