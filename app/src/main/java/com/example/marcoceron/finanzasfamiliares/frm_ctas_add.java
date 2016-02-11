package com.example.marcoceron.finanzasfamiliares;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class frm_ctas_add extends AppCompatActivity {
    EditText mTxt;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_ctas_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTxt = (EditText) findViewById(R.id.txtCta);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent c = new Intent(this, cuentas.class);
        switch (id) {
            case R.id.action_save:
                String Titulo = mTxt.getText().toString();
                if (Titulo.equals("")) {
                    Toast.makeText(this, "La Cuenta debe de tener un Nombre", Toast.LENGTH_SHORT).show();
                } else {
                    DBfamilybudget DBH = new DBfamilybudget(this);
                    SQLiteDatabase db = DBH.getWritableDatabase();
                    if (db != null) {
                        ContentValues agregar = new ContentValues();
                        agregar.put("nombre", Titulo);
                        long i = db.insert(tbl_cuentas.TABLE_NAME, null, agregar);
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

    public void Guardar(View view) {


    }


}
