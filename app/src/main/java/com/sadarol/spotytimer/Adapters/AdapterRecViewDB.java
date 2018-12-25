package com.sadarol.spotytimer.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sadarol.spotytimer.R;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AdapterRecViewDB <VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {//Шо это и почему так?
    private Cursor cursor;
    private Context context;
    private int mRowIdColumn;

    public AdapterRecViewDB(Cursor cursor, Context context) {
        this.cursor = cursor;
        mRowIdColumn = cursor != null ? cursor.getColumnIndex("id") : -1;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public abstract void onBindViewHolder(VH viewHolder, Cursor cursor);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindViewHolder(holder, cursor);
    }

    @Override
    public int getItemCount() {
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }


    @Override
    public long getItemId(int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            return cursor.getLong(mRowIdColumn);
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }

    }
}
