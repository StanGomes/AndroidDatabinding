package com.example.stan.stansgiftshop.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Product implements Parcelable {

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    private static final String TAG = Product.class.getSimpleName();
    private String title, description;
    private int image, numRatings, serialNum;
    private BigDecimal price, salePrice, rating;

    public Product(String title, String description, int image, BigDecimal price, BigDecimal salePrice, int numRatings, BigDecimal rating, int serialNum) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.numRatings = numRatings;
        this.serialNum = serialNum;
        this.price = price;
        this.salePrice = salePrice;
        this.rating = rating;
    }

    public Product() {

    }

    protected Product(Parcel in) {
        title = in.readString();
        description = in.readString();
        image = in.readInt();
        numRatings = in.readInt();
        serialNum = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(image);
        parcel.writeInt(numRatings);
        parcel.writeInt(serialNum);
    }

    public boolean hasSalePrice(){
        double salesPrice = salePrice.doubleValue();
        return salesPrice > 0;
    }

    public String getNumberRatingsString(){
        return ("(" + getNumRatings() + ")");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}
