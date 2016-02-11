package com.example.marcoceron.finanzasfamiliares;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class frm_fondos_add extends AppCompatActivity {
    EditText mTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_fondos_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTxt = (EditText) findViewById(R.id.txtTitulo);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent c = new Intent(this, fondos.class);
        int id = item.getItemId();
        switch (id) {
            case R.id.action_save:
                String titulo = mTxt.getText().toString();
                if (titulo.equals("")) {
                    Toast.makeText(this, "Escribe un Fondo", Toast.LENGTH_SHORT).show();
                } else {
                    DBfamilybudget DBH = new DBfamilybudget(this);
                    SQLiteDatabase db = DBH.getWritableDatabase();
                    if (db != null) {
                        ContentValues agregar = new ContentValues();
                        agregar.put("titulo", titulo);
                        long i = db.insert(tbl_fondos.TABLE_NAME, null, agregar);
                        if (i > 0) {
                            Toast.makeText(this, "Registro creado con exito", Toast.LENGTH_SHORT).show();
                            startActivity(c);
                        }
                    }
                }
                break;
            case R.id.action_exit:
                startActivity(c);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
