package com.sadarol.spotytimer.Presentation.Adapter;

import android.view.View;

public interface RecViewDbClick {
    public void recyclerViewListClicked(View v, int position, int id);
    public void deleteButtonClicked(int position, int id);
}
