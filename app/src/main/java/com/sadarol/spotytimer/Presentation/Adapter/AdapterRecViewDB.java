package com.sadarol.spotytimer.Presentation.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

public abstract class AdapterRecViewDB<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>
        {
    private Cursor mCursor;
    private Context context;
    private int mRowIdColumn;


    public AdapterRecViewDB(Cursor cursor, Context context) {

        mCursor = cursor;
        mRowIdColumn = cursor != null ? cursor.getColumnIndex("id") : -1;
        Log.i("AdapterRecViewRVDB", "CursorColumnIndex " + Integer.toString(cursor.getColumnIndex("id")));
        Log.i("AdapterRecViewRVDB", "mRowIdColumn " + Integer.toString(mRowIdColumn));
        setHasStableIds(true);
    }


    public abstract void onBindViewHolder(VH viewHolder, Cursor cursor);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Log.i("AdapterRVDB.onBind", "position " + Integer.toString(position));
        Log.i("AdapterRVDB.onBind", "position " + Integer.toString(mCursor.getPosition()));
        if (!mCursor.moveToPosition(position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }
        Log.i("AdapterRVDB.onBind", "position " + Integer.toString(mCursor.getPosition()));
        onBindViewHolder(holder, mCursor);
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        if (mCursor != null) {
            Log.i("AdapterRVDB.getItemCoun", Integer.toString(mCursor.getCount()));
            return mCursor.getCount();
        }
        return 0;
    }


    @Override
    public long getItemId(int position) {
        Log.i("AdapterRVDB.getItemId", Integer.toString(position));
        if (mCursor != null && mCursor.moveToPosition(position)) {
            Log.i("AdapterRVDB.getItemIdMC", Integer.toString(position));
            return mCursor.getLong(mRowIdColumn);
        }
        return -1;
    }

}
