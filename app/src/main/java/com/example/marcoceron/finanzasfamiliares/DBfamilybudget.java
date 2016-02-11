package com.example.marcoceron.finanzasfamiliares;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marco.ceron on 21/01/2016.
 */
public class DBfamilybudget extends SQLiteOpenHelper {

    private static final String DB_NAME = "familybudget";
    private static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;

    public DBfamilybudget(Context context) {
        super(context, DB_NAME, null, SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbl_cuentas.CREATE_DB_TABLE);
        db.execSQL(tbl_fondos.CREATE_DB_TABLE);
        db.execSQL(tbl_categorias.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
