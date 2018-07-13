package com.example.stan.stansgiftshop.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stan.stansgiftshop.R;
import com.example.stan.stansgiftshop.databinding.FragmentProductDetailBinding;
import com.example.stan.stansgiftshop.model.Product;
import com.example.stan.stansgiftshop.viewModel.ProductViewModel;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ProductDetailFragment extends Fragment {

    private static final String TAG = ProductDetailFragment.class.getSimpleName();
    private static ProductDetailFragment newInstance;

    private Product product;

    //data binding
    private FragmentProductDetailBinding fragmentProductDetailBinding;

    public static synchronized ProductDetailFragment getNewInstance(){
        if (newInstance == null){
            newInstance = new ProductDetailFragment();
        }

        return newInstance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null){
            product = bundle.getParcelable(getString(R.string.intent_product));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentProductDetailBinding = FragmentProductDetailBinding.inflate(inflater);

        ProductViewModel productViewModel = new ProductViewModel();
        productViewModel.setProduct(product);
        productViewModel.setQuantity(1);
        fragmentProductDetailBinding.setProductViewModel(productViewModel);

        return fragmentProductDetailBinding.getRoot();

    }
}
