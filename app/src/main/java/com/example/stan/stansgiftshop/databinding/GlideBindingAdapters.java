package com.example.stan.stansgiftshop.databinding;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.example.stan.stansgiftshop.R;

import androidx.databinding.BindingAdapter;

/*************************
 *Author : Stanley Gomes *
 *Since : 01/06/2018     *
 *************************/
public class GlideBindingAdapters {
    @BindingAdapter("imageUrl")
    public static void setImage(ImageView image, int imageRes){
        Context context = image.getContext();

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(imageRes)
                .into(image);
    }

    @BindingAdapter({"requestListener", "imageRes"})
    public static void bindRequestListener(ImageView imageView, RequestListener requestListener, int imageRes){
        Context context = imageView.getContext();

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(imageRes)
                .listener(requestListener)
                .into(imageView);
    }
}
