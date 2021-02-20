package com.assignment.picsumbrowser;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.picsumbrowser.databinding.ItemHolderBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    /**
     * List to hold the data from the Json
     */
    private List<PicsumPojo> picsumPojos;

    public RecyclerViewAdapter( List<PicsumPojo> picsumPojoList) {
        this.picsumPojos = picsumPojoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHolderBinding itemHolderBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_holder, parent, false);
        return new ViewHolder(itemHolderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PicsumPojo picsumPojo = picsumPojos.get(position);
        holder.itemHolderBinding.setPicsum(picsumPojo);
    }

    @Override
    public int getItemCount() {
        return picsumPojos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemHolderBinding itemHolderBinding;

        public ViewHolder(@NonNull ItemHolderBinding itemView) {
            super(itemView.getRoot());
            itemHolderBinding = itemView;
        }
    }
}
