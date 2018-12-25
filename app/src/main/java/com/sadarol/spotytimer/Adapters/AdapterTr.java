package com.sadarol.spotytimer.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadarol.spotytimer.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTr extends AdapterRecViewDB<AdapterTr.ViewHolder> {

    public AdapterTr(Cursor cursor, Context context) {
        super(cursor, context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tr, parent, false);
        v.setVisibility(View.VISIBLE);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, Cursor cursor) {
        ModelTr modelTr = ModelTr.fromCursor(cursor);
        holder.name.setText(modelTr.getName());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name_tr);
        }
    }
}
