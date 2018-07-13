package com.example.stan.stansgiftshop.viewModel;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.stan.stansgiftshop.BR;
import com.example.stan.stansgiftshop.model.Product;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/*************************
 *Author : Stanley Gomes *
 *Since : 01/06/2018     *
 *************************/
public class ProductViewModel extends BaseObservable {

    private Product product;
    private int quantity;
    private boolean imageVisibility = false;

    @Bindable
    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
        notifyPropertyChanged(BR.product);
    }

    @Bindable
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(BR.quantity);
    }

    @Bindable
    public boolean isImageVisibility() {
        return imageVisibility;
    }

    public void setImageVisibility(boolean imageVisible) {
        this.imageVisibility = imageVisible;
        notifyPropertyChanged(BR.imageVisibility);
    }

    public RequestListener getCustomRequestListener(){
        return new RequestListener() {
            @Override
            public boolean onLoadFailed(GlideException e, Object model, Target target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                setImageVisibility(true);
                return false;
            }
        };
    }
}
