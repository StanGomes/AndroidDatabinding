package com.example.stan.stansgiftshop.ui;

import android.os.Bundle;

import com.example.stan.stansgiftshop.R;
import com.example.stan.stansgiftshop.adapter.ProductClickListener;
import com.example.stan.stansgiftshop.databinding.ActivityMainBinding;
import com.example.stan.stansgiftshop.model.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ProductClickListener {

    //data binding
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
    }

    // This is really in the realm of realism.

    private void init(){
        MainFragment mainFragment = MainFragment.getNewInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, mainFragment, getString(R.string.fragment_main));
        fragmentTransaction.commit();
    }

    @Override
    public void navigatoToProductDetail(Product product) {
        ProductDetailFragment productDetailFragment = ProductDetailFragment.getNewInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelable(getString(R.string.intent_product), product);
        productDetailFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, productDetailFragment, getString(R.string.fragment_product_detail))
                .addToBackStack(getString(R.string.fragment_product_detail))
                .commit();
    }
}
