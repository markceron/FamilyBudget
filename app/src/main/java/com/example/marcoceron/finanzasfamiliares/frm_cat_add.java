package com.example.marcoceron.finanzasfamiliares;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class frm_cat_add extends AppCompatActivity {

    Spinner cmbTipo;
    EditText cTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cat_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner tipo = (Spinner) findViewById(R.id.cmbTipo);
        ArrayAdapter<CharSequence> spinner_tipo = ArrayAdapter.createFromResource(this, R.array.cat, android.R.layout.simple_spinner_item);
        spinner_tipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(spinner_tipo);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent c = new Intent(this, categorias.class);
        cmbTipo = (Spinner) findViewById(R.id.cmbTipo);
        cTxt = (EditText) findViewById(R.id.txtCat);
        switch (id) {
            case R.id.action_save:
                String Tipo = cmbTipo.getSelectedItem().toString();
                String Cat = cTxt.getText().toString();

                if (Cat.equals("")) {
                    Toast.makeText(this, "El campo Categoria no debe de ser vacio", Toast.LENGTH_SHORT).show();
                } else {
                    switch (Tipo) {
                        case "Seleccione un tipo":
                            Toast.makeText(this, "Debes de escoger un tipo", Toast.LENGTH_SHORT).show();
                            break;
                        case "Ingreso":
                            Toast.makeText(this, "Creaste una categoria de Ingreso", Toast.LENGTH_SHORT).show();
                            break;
                        case "Gasto":
                            Toast.makeText(this, "Creaste una categoria de Gasto", Toast.LENGTH_SHORT).show();
                            break;
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
