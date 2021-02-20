package com.assignment.picsumbrowser;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/*
Pojo class to hold the values received from the JSON
 */
public class PicsumPojo {

    private String format;
    private Integer width;
    private Integer height;
    private String filename;
    private Integer id;
    private String author;
    private String authorUrl;
    private String postUrl;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, int id) {
        ImageView ivImage = (ImageView) view;
        String url = "https://picsum.photos/300/300?image=" + id;
        Glide.with(ivImage.getContext()).load(url).apply(RequestOptions.circleCropTransform()).into(ivImage);
    }

}