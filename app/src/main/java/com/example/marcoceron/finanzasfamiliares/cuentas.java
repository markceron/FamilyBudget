package com.example.marcoceron.finanzasfamiliares;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cuentas extends AppCompatActivity {

    public ItemAdapter adaptador;
    ListView li;
    ArrayList<tbl_cuentas> lista = new ArrayList<tbl_cuentas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_ctas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fb_cta_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cuentas.this, ctas_add.class);
                startActivity(i);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        li = (ListView) findViewById(R.id.lstCtas);
        tbl_cuentas datos;

        DBfamilybudget DBH = new DBfamilybudget(this);
        SQLiteDatabase db = DBH.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery(tbl_cuentas.SELECT_ALL, null);
            if (c.moveToFirst()) {
                do {
                    datos = new tbl_cuentas(c.getString(1), c.getDouble(2));
                    lista.add(datos);
                } while (c.moveToNext());
            }

        }
        ItemAdapter adapter = new ItemAdapter(this, lista);
        li.setAdapter(adapter);

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.lblNombre);
                Toast.makeText(cuentas.this, "Has Seleccionado a la Cta: " + v.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public class ItemAdapter extends BaseAdapter {

        private Context context;
        private List<tbl_cuentas> items;

        public ItemAdapter(Context context, List<tbl_cuentas> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        @Override
        public Object getItem(int position) {
            return this.items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;

            if (convertView == null) {
                // Create a new view into the list.
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.items_ctas, parent, false);
            }

            TextView lblNombre = (TextView) rowView.findViewById(R.id.lblNombre);
            TextView lblMonto = (TextView) rowView.findViewById(R.id.lblMonto);

            tbl_cuentas item = this.items.get(position);
            lblNombre.setText(item.getNombre());
            lblMonto.setText(String.valueOf(item.getMonto()));

            return rowView;
        }
    }

}
