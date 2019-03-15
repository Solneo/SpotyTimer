package com.sadarol.spotytimer.Presentation.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sadarol.spotytimer.Data.Model.ModelTr;
import com.sadarol.spotytimer.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTr extends AdapterRecViewDB<AdapterTr.ViewHolder> implements RecViewDbClick {
    private static RecViewDbClick itListener;

    public AdapterTr(Cursor cursor, Context context, RecViewDbClick itListener) {
        super(cursor, context);
        this.itListener = itListener;
    }

    public void recyclerViewListClicked(View v, int position, int str) {
        Log.d("errr",
                "0");
    }

    @Override
    public void deleteButtonClicked(int position, int id) {
        Log.d("errr",
                "0");
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, Cursor cursor) {
        ModelTr modelTr = ModelTr.fromCursor(cursor);
        holder.name.setText(modelTr.getName());
        holder.id = modelTr.getId();
        if (modelTr.getDescription() != null && !modelTr.getDescription().contentEquals("")) {
            holder.desc.setText(modelTr.getDescription());
            holder.desc.setVisibility(View.VISIBLE);
        }
        holder.position = cursor.getPosition();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itListener.deleteButtonClicked(holder.position, holder.id);
            }
        };
        holder.delete.setOnClickListener(onClickListener);


    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView desc;
        Button delete;
        int id;
        int position;

        @Override
        public void onClick(View v) {
            itListener.recyclerViewListClicked(v, this.getLayoutPosition(), id);
        }

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            name = (TextView) v.findViewById(R.id.name_tr);
            desc = (TextView) v.findViewById(R.id.description);
            delete = (Button) v.findViewById(R.id.button_del);


        }
    }
}
