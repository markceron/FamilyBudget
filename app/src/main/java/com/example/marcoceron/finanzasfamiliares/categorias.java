package com.example.marcoceron.finanzasfamiliares;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class categorias extends AppCompatActivity {

    ListView li;
    ArrayList lista = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_cat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fb_cat_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(categorias.this, frm_cat_add.class);
                startActivity(i);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DBfamilybudget DBH = new DBfamilybudget(this);
        SQLiteDatabase db = DBH.getWritableDatabase();

        li = (ListView) findViewById(R.id.lstCat);

        if (db != null) {
            Cursor c = db.rawQuery(tbl_categorias.SELECT_ALL, null);
            if (c.moveToFirst()) {
                do {
                    lista.add(c.getString(1));
                } while (c.moveToNext());
            }
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        li.setAdapter(adapter);
    }
}
