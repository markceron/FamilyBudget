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

public class frm_cat_add extends AppCompatActivity {
    EditText cTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cat_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent c = new Intent(this, categorias.class);
        cTxt = (EditText) findViewById(R.id.txtCat);
        switch (id) {
            case R.id.action_save:
                String Cat = cTxt.getText().toString();

                if (Cat.equals("")) {
                    Toast.makeText(this, "El campo Categoria no debe de ser vacio", Toast.LENGTH_SHORT).show();
                } else {
                    DBfamilybudget DBH = new DBfamilybudget(this);
                    SQLiteDatabase db = DBH.getWritableDatabase();
                    if (db != null) {
                        ContentValues agregar = new ContentValues();
                        agregar.put("titulo", Cat);
                        long i = db.insert(tbl_categorias.TABLE_NAME, null, agregar);
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
