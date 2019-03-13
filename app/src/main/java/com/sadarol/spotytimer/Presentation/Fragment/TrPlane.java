package com.sadarol.spotytimer.Presentation.Fragment;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sadarol.spotytimer.Data.DataCRUT;
import com.sadarol.spotytimer.Data.DatabaseHelper;
import com.sadarol.spotytimer.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class TrPlane extends Fragment {
    EditText etName, etEmail;
    Button btnAdd, btnRead, btnClear;
    private DatabaseHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plane_tr, container, false);
        bind(v);
        return v;
    }

    private void bind(View v) {
        etName = (EditText) v.findViewById(R.id.editName);
        etEmail = (EditText) v.findViewById(R.id.editMail);
        dbHelper = new DatabaseHelper(getActivity());
        btnAdd = (Button) v.findViewById(R.id.button_add);
        addListener(btnAdd);
        btnRead = (Button) v.findViewById(R.id.button_read);
        readListener(btnRead);
        btnClear = (Button) v.findViewById(R.id.button_clean);
        clearListener(btnClear);
    }

    public void addListener(View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String mail = etEmail.getText().toString();
                DataCRUT dataCRUT = new DataCRUT(dbHelper, getActivity());
                ContentValues cv = new ContentValues();
                cv.put("name", name);
                cv.put("time", mail);
                dataCRUT.dbAdd("training", cv);
            }
        });
    }

    private void readListener(View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataCRUT dataCRUT = new DataCRUT(dbHelper, getActivity());
                dataCRUT.dbRead();
            }
        });
    }

    private void clearListener(View v) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataCRUT dataCRUT = new DataCRUT(dbHelper, getActivity());
                dataCRUT.dbClearTable("training");
            }
        });
    }

}